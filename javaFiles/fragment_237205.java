public class Hundred {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    @XmlElement
    public void setItems(List<Item> items) {
        this.items = items;
    }
}

public class TwentySeven {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    @XmlElement
    public void setItems(List<Item> items) {
        this.items = items;
    }
}

public class Item {
    //private <Object of type One>
    //private <Object of type Two>

    /*
     * Write getter setter methods and add annotations
     * accordingly as shown in other sample methods.
     */
}

public class Profile {
    private Abc item;

    public Abc getItem() {
        return item;
    }

    @XmlElement
    public void setItem(Abc item) {
        this.item = item;
    }

    //Bcd also goes in same way
}

public class Abc {
    private String param1;

    private String param2;

    public String getParam1() {
        return param1;
    }

    @XmlElement
    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    @XmlElement
    public void setParam2(String param2) {
        this.param2 = param2;
    }
}