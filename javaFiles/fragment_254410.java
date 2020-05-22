class StopsJSON {
    private int status;
    private ArrayList<Integer> routes;

    public StopsJSON(int status, ArrayList<Integer> route) {
        // super();
        this.status = status;
        this.routes = route;
    }

    public int getStatus() {
        return status;
    }

    public ArrayList<Integer> getRoutes() {
        return routes;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRoutes(ArrayList<Integer> routes) {
        this.routes = routes;
    }

}