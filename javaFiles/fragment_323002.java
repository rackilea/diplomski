public void invalidateAllUsers() {
    logger.entering(getUser(ctx), "invalidateAll()"); // getUser returns a string with the current user ( context.getCallerPrincipal().getName() ).

    try {
        UserHome home = (UserAuthHome) getHome("User", UserHome.class); // Looks up the home interface
        CachingHome cache = (CachingHome)home;  // Sweet weblogic magic!
        cache.invalidateAll();
    } catch (RemoteException e) {
        logger.severe(getUser(ctx), "invalidate(date)", "got RemoteException", e);
        throw new EJBException(e);
    }
}