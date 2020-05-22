StringBuilder sb = new StringBuilder();
while (rs.next()) {
  String DS_ESTRATEGIA = rs.getString(1);
  String ID_ESTRATEGIA = rs.getString(2);
  System.out.println(DS_ESTRATEGIA + "  " + ID_ESTRATEGIA);
  sb.append(DS_ESTRATEGIA + "  " + ID_ESTRATEGIA + "\n");
}
resultdao = sb.toString();