private List<String> getRatesItemNamelist(){
    List<String> list = new ArrayList<>();
    for (String[] rates : ratesarray) {
        list.add(rates[0]);
    }
    return list;
}