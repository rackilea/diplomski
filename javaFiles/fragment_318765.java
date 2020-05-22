connectionPoolSettings = ConnectionPoolSettings
                    .builder()
                    .minSize(getMinConnectionsPerHost())
                    .maxSize(getConnectionsPerHost())
                    .maxWaitQueueSize(getThreadsAllowedToBlockForConnectionMultiplier()
                    * getConnectionsPerHost())
                    .maxWaitTime(getMaxWaitTime(), MILLISECONDS)
                    .maxConnectionIdleTime(getMaxConnectionIdleTime(), MILLISECONDS)
                    .maxConnectionLifeTime(getMaxConnectionLifeTime(), MILLISECONDS)
                    .build();