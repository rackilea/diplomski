List<String> newList = new ArrayList<>();
String startToken = "Bolus Exposure (Impedance) Total";
String endToken = "Longest Episode    11.2 min";
boolean startAdding = false;

for(String element: array) {
    if(startToken.equals(element)) {
        startAdding = true;
    } else if(endToken.equals(element)) {
        newList.add(element);
        break;
    }
    if(startAdding) {
        newList.add(element);
    }
}