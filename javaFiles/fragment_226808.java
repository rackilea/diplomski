ActionContext context = ActionContext.getContext();
    SessionMap<String, T> sessionMap = (SessionMap<String, T>) context.getSession();

    if (sessionMap == null) {
        sessionMap = new SessionMap<String, T>(ServletActionContext.getRequest());
        context.setSession((Map<String, Object>) sessionMap);
    }