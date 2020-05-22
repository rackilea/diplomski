class NodesDetail{
    private ArrayList<NoteId> Nodes;
    private String utc;
}

class NoteId{
    private String Node_id;
}

...
NodesDetail obj = new Gson().fromJson(reader, NodesDetail.class);
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(obj));