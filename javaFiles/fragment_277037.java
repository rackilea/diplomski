class DomainClass {
     public InnerDomain domain;
}

class MenuItem {
     public String value;
     public String onclick;
}

class PopupClass {
    public List<MenuItem> menuitem1;

}

class InnerDomain {
     public String id;
     public String value;
     public PopupClass popup;
}