public class MyJsonResponse
{
    private boolean HasChanged;
    private int Version;
    private long LastModifiedDate;
    private List<DataCenter> DATACENTERS;

    // Getters/Setters for above
}

public class DataCenter
{
    private String Name;
    private int TotalNumberOfServers;
    private List<Map<String,String>> PrimaryData;
    private List<Map<String,String>> SecondaryData;
    private List<Map<String,String>> MachineMapping; 

    // getters and setters for all of the above
}