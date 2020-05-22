Server server;
try {
    server = ...;
    server.foo();
    server.bar();
    ...
} finally {
    if (server) {
        server.close();
    }
}