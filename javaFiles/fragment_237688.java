import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ChildAdapter extends XmlAdapter<ChildAdapter.Parent, Child> {

    public static class Parent {
        public Child child;
    }

    @Override
    public Parent marshal(Child v) throws Exception {
        Parent parent = new Parent();
        parent.child = v;
        return parent;
    }

    @Override
    public Child unmarshal(Parent v) throws Exception {
        return v.child;
    }

}