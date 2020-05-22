for (;;) {
    Credentials local = credentials;
    try {
        getData(local);
        break;
    }
    catch (UnauthorizedException e) {
        synchronized (this) {
            if (credentials == local) {
                credentials = login();
            }
        }
    }
}