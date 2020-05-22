private void processItemEvent(ExchangeService service, String mailbox, ItemEvent itemEvent) throws Exception {
        synchronized(service) {
            service.setImpersonatedUserId(impersonateAccount(mailbox));
            service.getHttpHeaders().put("X-AnchorMailbox", mailbox);
            service.getHttpHeaders().put("X-PreferServerAffinity", "true");
                try {
                   ...
                } catch (Exception ie) {
                   ...
                }
            }
      }