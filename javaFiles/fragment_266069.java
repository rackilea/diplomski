@Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        new DriverLoader();
        Confirmpage = getInitParameter("Confirmpage");
        ResultURL = getInitParameter("ResultURL");
    }