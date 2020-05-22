JsonReader reader = new JsonReader(new FileReader("topojson.json"));
Gson gson = new Gson();
TopoJsonNetwork topoNet = gson.fromJson(reader, TopoJsonNetwork.class);

for (Double[][] d : topoNet.arcs) {
    for (int i = 0; i < d.length; i++) {
        for (int j = 0; j < d[i].length; j++) {
            System.out.println(d[i][j]);
        }
    }
}