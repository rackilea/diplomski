public class HotelMenu {
public static String crateHotelMenuJson(Statement stmt) throws Exception {
    JSONArray hotels = new JSONArray();
    JSONObject menu = new JSONObject();
    String sql = "SELECT * FROM tb_hotel where Status='1'";
    ResultSet hotelResultSet = stmt.executeQuery(sql);
    while (hotelResultSet.next()) {
        JSONObject hotel = new JSONObject();
        hotel.put("id", hotelResultSet.getInt("Id"));
        hotel.put("code", hotelResultSet.getString("Code"));
        hotel.put("name", hotelResultSet.getString("Name"));
        hotel.put("status", hotelResultSet.getString("Status"));

        sql = "SELECT * FROM tb_subItem  where Status='1' ";
        ResultSet subItemResultSet = stmt.executeQuery(sql);
        JSONArray subItems = new JSONArray();
        while (subItemResultSet.next()) {
            JSONObject hotelMenu = new JSONObject();
            hotelMenu.put("id", subItemResultSet.getInt("Id"));
            hotelMenu.put("name", subItemResultSet.getString("Name"));
            hotelMenu.put("price", subItemResultSet.getString("Price"));
            subItems.put(hotelMenu);
        }
        hotel.put("sub_items", subItems);
        hotels.put(hotel);
    }
    menu.put("items", hotels);
    JSONObject result = new JSONObject();
    result.put("menu", menu);
    return result.toString();
}}