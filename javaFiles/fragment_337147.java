OkHttpSingleton localSingleton = OkHttpSingleton.getInstance();
...
localSingleton.closeConnections();
...
OkHttpClient localClient = localSingleton.getClient();
// or
OkHttpClient localClient = OkHttpSingleton.getInstance().getClient();