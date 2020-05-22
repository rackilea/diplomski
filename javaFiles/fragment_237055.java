Class MyData
{
    private String[] fixedData;
    private List<String> variableData;
    public MyData(int fixedSizeN) {
         fixedData = new String[fixedSizeN];
         variableData = new ArrayList<String>();
    }
    //public get/set go here
}

List<MyData> comboData;