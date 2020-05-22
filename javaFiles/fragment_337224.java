public class CustomWrapper{

    private Map<String, Object> customMap= new HashMap<String, Object>();

    public Map<String, Object> getCustomMap() {
        return customMap;
    }

    public void setCustomMap(Map<String, Object> customMap) {
        this.customMap = customMap;
    }

}

@RequestParam("days") CustomWrapper days