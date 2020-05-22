public static void main(String[] args) throws IOException {
    JacksonUtils JacksonUtils = new JacksonUtilsImpl();

    Collection<Base> data = new LinkedBlockingQueue<Base>();
    data.add(new ConcreteA());
    data.add(new ConcreteB());
    data.add(new ConcreteC());

    String json = JacksonUtils.marshallIntoString(data);

    System.out.println(json);

    Collection<? extends Adapter> adapters = JacksonUtils.unmarshall(json, new TypeReference<ArrayList<Adapter>>() {});

    for (Adapter adapter : adapters) {
        System.out.println(adapter.getClass().getName());
    }
}