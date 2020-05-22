class ServerThread extends Thread {

    private javax.servlet.Servlet servlet;
    private javax.servlet.ServletRequest req;
    private javax.servlet.ServletResponse res;

    public ServerThread(javax.servlet.Servlet servlet, /* request and response */) {
        this.servlet = servlet;
        this.req = req;
        this.res = res;
    }

    @Override
    public void run() {
        this.servlet.service(req, resp);
    }

}