public static String getJSONMessage(String gearSData) {
    System.out.println(gearSData);
    Gson gson = new Gson();
    DataModels model = gson.fromJson(gearSData, DataModels.class);
    System.out.println(model);
    for (DataModels.Container container : model) {

        System.out.println(container.type);
        String innerJson = gson.toJson(container.type == 1 ? container.Steps : container.HeartRate);
        System.out.println("InnerJson: " + innerJson);
        //...
    }
    return null;
}

public static class DataModels extends ArrayList<DataModels.Container> {
    public static class Container {
        public int type;
        public StepsType Steps; // object for type 1
        public HeartRateType HeartRate; // object for type 2
    }

    public static class StepsType {
        double steps;
        //...
    }

    public static class HeartRateType {
        int heartrates;
        //...
    }
}