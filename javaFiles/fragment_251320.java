class Table {

    String ID = "";
    String name = "";

    Table(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString(){
        return ID+" - "+ name;      // you can give the string any form you want and you can print anything you want. All that is required is that you return a String in that method.
    }
}