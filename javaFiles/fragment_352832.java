class Main {
    public static void main(String[] args) {
        List<String> exampleList = new ArrayList<> (Arrays.asList(
          "Consultas.ControldeInformes", "Consultas.SaldoMora", 
          "Consultas.ReporteMensual", "Mantenimientos.Agregar", 
          "Mantenimientos.Editar", "Mantenimientos.Actualizar"

        ));
    System.out.print(mapInput(exampleList).toString());
  }

 private static Map<String,List<String>> mapInput(List<String> input) {

    Map<String,List<String>> map = new HashMap<>();

    input.stream()
      .map(x->getMenu(x))
      .distinct()
      .forEach(x->map.put(x, new ArrayList<>()));

    for (String item : input) {
      List<String> subMenus = map.get(getMenu(item));
      subMenus.add(getSubMenu(item));

      map.put(getMenu(item), subMenus);
    }

    return map;
  }

  private static String getMenu(String item){
    return item.split("\\.")[0];
  }

  private static String getSubMenu(String item){
    return item.split("\\.")[1];
  }
}