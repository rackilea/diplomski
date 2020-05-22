public class MyAdapter extends XmlAdapter<MyAdapter.MyJaxbObject, MyObject> {
    @Override
    public MyObject unmarshal(MyJaxbObject src) throws Exception {
        MyObject tgt = SomeMagic.createMyObject();
        BeanUtils.copyProperties(tgt, src);
        return tgt;
    }

    @Override
    public MyObject marshal(MyObject src) throws Exception {
        MyJaxbObject tgt = new MyJaxbObject();
        BeanUtils.copyProperties(tgt, src);
        return tgt;
    }

    public static class MyJaxbObject {
       ...
    }
}