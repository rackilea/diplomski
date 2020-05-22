private Map<String, Object> data;
    int nextIndex = 1;

    private void init(){
        this.data = new HashMap<String, Object>();
    }

    public void addModel(Object newModel){
            this.data.add("Property" + this.nextIndex, newModel);
            this.nextIndex++;
    }