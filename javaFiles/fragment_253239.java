public void parseJson() {
    TopLevel t = getGson().fromJson(json, TopLevel.class);

    for (ResponseElement element : t.elements) {
        System.out.println(element);
    }
}