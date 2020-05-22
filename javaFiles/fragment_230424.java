UserSession user = users.get(sessionId);

    if (user != null) {
        log.info("[Handler::presenterSwitch] Switching presenter to: {} ", sessionId);
        dispatcher.setSource(user.getHubPort());
    }else{
        log.error("[Handler::presenterSwitch] Trying to switch to an no-existent session: {}", sessionId);
    }