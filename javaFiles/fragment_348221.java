private Map<String, String> typesNames ;
    private List<String> selectedTypes;

    public void fillMap() {
        typesNames = new HashMap<String,String>();

            typesNames .put("A", "Type A");

            typesNames .put("B", "Type B");

            typesNames .put("C", "Type C");
        selectedTypes = new ArrayList<String>(typesNames .keySet());
    }

    public Map<String, String> getMap(){
         return typesNames ;
    }

    public List<String> getKeyList(){
         return selectedTypes;
    }