public class SubType extends SuperType{

    public SubType(ArrayList<GenericObject<Y>> g) {
        super(g);
    }
}

public class SuperType {

    public ArrayList<GenericObject<?>> data = new ArrayList<GenericObject<? extends X>>();

    public SuperType(ArrayList<? extends GenericObject<? extends X>> series) {

        data.addAll(series);
    }
}


class GenericObject<T extends X>{}
class X{};
class Y extends X{};