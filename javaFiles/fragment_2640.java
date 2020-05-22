public class SessionFacade {
        private String leaderLock;
        private String sessionId;
        private Consul client;
        private Config config;

        public SessionFacade(Consul client, Config config) {
            this.client = client;
            this.config = config;
            this.leaderLock = "service/" + config.getService().getName() + "/leader";
            this.sessionId = createSession();
            new SessionHeartBeater(client, sessionId, config.getService().getSessionTtl()).start();
            watchLeaderLockStateChange(sessionId);
            client.keyValueClient().acquireLock(leaderLock, sessionId);
        }

        public boolean doIPossesLeaderLock() {
            Optional<Value> leaderValue = client.keyValueClient().getValue(leaderLock);
            if(leaderValue.isPresent()) {
                Optional<String> session = leaderValue.get().getSession();
                return session.isPresent() && session.get().equals(sessionId);
            }
            return false;
        }

        private String createSession() {
            int sessionTtl = config.getService().getSessionTtl();
            final Session session = ImmutableSession.builder()
                    .name(config.getService().getName())
                    .ttl(sessionTtl + "s")
                    .build();
            return client.sessionClient().createSession(session).getId();
        }

        private void watchLeaderLockStateChange(String sessionId) {
            KeyValueClient keyValueClient = client.keyValueClient();
            KVCache kvCache = KVCache.newCache(keyValueClient, leaderLock, config.getService().getWatchLockEach());
            kvCache.addListener(map -> {
                Value value = map.get(leaderLock);
                if(!value.getSession().isPresent()) {
                    keyValueClient.acquireLock(leaderLock, sessionId);
                }
            });
            kvCache.start();
        }
    }