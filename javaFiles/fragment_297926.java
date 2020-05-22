String parametroGSON ="";
try {
  Map<String, List<?>> mapa = new LinkedHashMap<String, List<?>>();
  mapa.put("ttPrm", listParam);
  mapa.put("ttDet", ListaArt);
  parametroGSON = new Gson().toJson(mapa);
} catch (Exception e) { }
System.out.println(json);