class NodesDetail{
    private ArrayList<NoteId> Nodes;
    private String utc;
    private String DeliveryTime;
    private String Ifr;
}

class NoteId{
    private String Node_id;
    private String count;
}
...
NodesDetail obj = new Gson().fromJson(reader, NodesDetail.class);
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(obj));