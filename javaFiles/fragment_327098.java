@Override
    public void init() {
        Parameters params = getParameters();
        Map<String, String> named = params.getNamed();
        System.out.println(named);
    }