ArrayList<String[]> NewArray = new ArrayList<String[]>();
for (Integer[] combination : combinations) {
    String[] newCombination = new String[2];
    if (combination[0].intValue() == 0) {
       newCombination[0] = "Vial1";
    }
    ... etc for other possible values
    if (combination[1].intValue() == 0) {
       newCombination[1] = "Vial1";
    }
    .. etc for other values
    NewArray.add(newCombination);
}