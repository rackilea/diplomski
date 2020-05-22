public ArrayList<Menu> getMenu() {
String SQL = "SELECT * FROM menu ORDER by id_kategori";
String nama, gambar;
int id_menu, id_kategori, harga, persediaan;
int count = 0;
ArrayList<Menu> arr = new ArrayList<>();
try (Connection conn = connect(); 
Statement stmt = conn.createStatement(); 
ResultSet cartRslt = stmt.executeQuery(SQL)) {
    while(cartRslt.next()) {
        id_menu = cartRslt.getInt("id_menu");
        id_kategori = cartRslt.getInt("id_kategori");
        harga = cartRslt.getInt("harga");
        persediaan = cartRslt.getInt("persediaan");
        nama = cartRslt.getString("nama");
        gambar = cartRslt.getString("gambar"); 
       arr.add(new Menu(id_menu, id_kategori, nama, harga, persediaan, gambar));
 }
 }
return arr;
}