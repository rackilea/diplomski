List<Function<MainObject, Object>> getters = Arrays.asList(
    o -> o.getObjOne().getStrAttribOne(),
    o -> o.getObjTwo().getStrAttribTwo(),
    o -> o.getObjOne().getIntAttribOne(),
    o -> o.getObjTwo().getIntAttribTwo()
);

for (int i = 0; i < mainObjects.size(); i++) {
    MainObject obj = mainObjects.get(i);
    System.out.println(getters.get(i).apply(obj));
}