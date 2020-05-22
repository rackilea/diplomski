public static List<Input> stringsFromInputs(List<Input> inputs) {
    List<String> ret = new ArrayList<String>();
    for(Input i : inputs)
        ret.add(i.getInput()); //Again, your class should have getters/setters
    return ret;
}