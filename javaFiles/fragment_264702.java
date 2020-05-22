List<String> resultdao = new ArrayList<>();

public List<String> returnDb(String Id_Estrategia1, String Id_Estrategia2) {
  ...
  while (rs.next()) {
    String DS_ESTRATEGIA = rs.getString(1);
    String ID_ESTRATEGIA = rs.getString(2);
    System.out.println(DS_ESTRATEGIA + "  " + ID_ESTRATEGIA);
    resultdao.add(DS_ESTRATEGIA + "  " + ID_ESTRATEGIA);
  }
  ...