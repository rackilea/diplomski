class Ports{

    private Map<String, Map<String, String>> ports = new HashMap<String, Map<String,String>>();

    public void addPort(String port){
        ports.put(port, new HashMap<String, String>());
    }

    public Map<String, Map<String, String>> getPorts() {
        return ports;
    }

    public void setPorts(Map<String, Map<String, String>> ports) {
        this.ports = ports;
    }
}