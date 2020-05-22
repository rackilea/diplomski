final SettableFuture<Boolean> future = SettableFuture.create();
    Transport transport = null;
    try {
        transport = session.getTransport("smtp");
        transport.addConnectionListener(new ConnectionListener() {
            @Override
            public void opened(ConnectionEvent connectionEvent) {
                future.set(((SMTPTransport) connectionEvent.getSource()).isConnected());
            }

            @Override
            public void disconnected(ConnectionEvent connectionEvent) {
            }

            @Override
            public void closed(ConnectionEvent connectionEvent) {
            }
        });
        transport.connect(config.getMailSMTPHost(),
                config.getMailSMTPPort(),
                config.getMailUsername(),
                config.getMailPassword());
    } catch (final MessagingException e) {
        future.setException(e);
    } finally{
        if(transport != null){
            transport.close();
        }
    }
    return future;