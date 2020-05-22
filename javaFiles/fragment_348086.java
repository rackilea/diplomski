public void setIndexedAttribute(String attribute, Variant value) {

    Variant[] indecies = new Variant[1];
    indecies[0] = new Variant(attribute);
    setProperty(signalGroup, "AttValue", indecies, value);

}

public void setProperty(Dispatch activex, String attributeName, Variant[] indecies,
        Variant value) {
    Variant[] variants = new Variant[indecies.length + 1];

    for (int i = 0; i < indecies.length; i++) {
        variants[i] = indecies[i];
    }
    variants[variants.length - 1] = value;

    Dispatch.invoke(activex, attributeName, Dispatch.Put, variants,new int[variants.length]);
}