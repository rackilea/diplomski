String name = nc.getName();
    String pass = String.valueOf(pc.getPassword());

    try {
        handler.handle(new Callback[]{nc, pc});
    } catch (Exception ex) {
        throw new LoginException(ex.getMessage());
    }