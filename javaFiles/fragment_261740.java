@FXML
private TabPane tp;

List<Button> buttonlist = new ArrayList<>();
List<Tab> tablist = new ArrayList<>();

Map<String, Tab> map= new HashMap<>();

ArrayList<String> nomProduits = new ArrayList<>();

@FXML
public void action() {
    try {
        Connection conn = bddUtil.dbConnect();
        tablist.clear();
        buttonlist.clear();
        ResultSet rs = conn.createStatement().executeQuery("select produit.nom, prix, type_produit.nom from produit inner join type_produit on produit.idType=type_produit.idType");
        while (rs.next()) {
            Tab tab = new Tab(rs.getString("type_produit.nom"));
            map.put(rs.getString("type_produit.nom"), tab);
            nomProduits.add(rs.getString("produit.nom"));
        }

        for (Tab tab : map.values()) {  
            FlowPane fp = new FlowPane();
            tab.setOnSelectionChanged(new EventHandler<Event>() {
                public void handle(Event event) {
                    fp.getChildren().clear();
                    for (int i = 0; i < nomProduits.size(); i++) {
                        Button btnPlat = new Button(nomProduits.get(i));
                        fp.getChildren().add(btnPlat);  
                    }
                    tab.setContent(fp);

                }
            });
        }
tp.getTabs().addAll(map.values());
    } catch (Exception e) {
        System.out.println("err: " + e);
        e.printStackTrace();
    }
}