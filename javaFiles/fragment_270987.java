public static void main(String args[]){
    String s = "[samsung,[\"samsung galaxy s9 case\",\"samsung galaxy s8 case\",\"samsung galaxy s9 plus case\",\"samsung galaxy s8 charger\"],[{\"nodes\":[{\"name\":\"Cell Phones & Accessories\",\"alias\":\"mobile\"}]},{},{},{},{},{},{},{},{},{}],[],\"1XQ3CN8WM8VSE\"]";

    String[] splitedFullString = s.split(",\\[");
    String sequence = splitedFullString[1];
    sequence = sequence.replaceAll("]", "");
    sequence = sequence.replaceAll("\"", "");
    String[] splitSequence = sequence.split(",");

    List<String> list = new ArrayList<>(); 
    for(String item : splitSequence){
        list.add(item);
    }
    for(String item : list){
        System.out.println(item);
    }
}