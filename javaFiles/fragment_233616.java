Iterator<?> it = list.entrySet().iterator();
while (it.hasNext()) {
    @SuppressWarnings("rawtypes")
    Map.Entry maps = (Map.Entry) it.next();
    lista.add(maps.getKey() + " " + maps.getValue());
}
}
public List<String> getResult() {
    List<String> temp = lista;
    return temp;
}