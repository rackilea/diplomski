public static void main(String a[]) throws Exception{
    ServerSocket srv = new ServerSocket(4444);

    while (listening) {
        new newthread(srv.accept());
    }
}