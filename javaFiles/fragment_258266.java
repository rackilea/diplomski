class FooAdapter extends XmlAdapter<Object[], Foo> {

    @Override
    public Object[] marshal(Foo v) throws Exception {
        return new Object[]{ v.x, v.y, v.z };
    }

    @Override
    public Foo unmarshal(Object[] v) throws Exception {
        Foo foo = new Foo();
        foo.x = (String) v[0];
        foo.y = (Integer) v[1];
        foo.z = (Double) v[2];
        return foo;
    }

}