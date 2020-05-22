class PanelRegion {

    private List<Runnable> listOfMethods = new ArrayList<>();

    public void addMethod(Runnable methodCall) {
        listOfMethods.add(methodCall);
    }

    public void invokeDrawMethods()
    {
         for(Runnable aMethod : listOfMethods) {
             aMethod.run();
         }
    }
}