List<List<String>> reservation = new ArrayList<>();
// ArrayList<String> singleList = new ArrayList<String>();
while (rs.next()){
    List<String> singleList = new ArrayList<>();
    singleList.add(rs.getString("name"));
    singleList.add(rs.getString("type"));
    singleList.add(rs.getString("view"));
    singleList.add(rs.getString("service"));
    singleList.add(rs.getString("checkin"));
    singleList.add(rs.getString("date"));
    reservation.add(singleList);
    // correct line System.out.println(reservation.get(0).get(0));
    // singleList.clear();
}