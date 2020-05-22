public enum TestEnum {

    Dropdown1("DropDown1"),
    DropDown2("DropDown2");

    private String str;

    TestEnum(String str){
       this.str = str;
    }

    public String getStr() {
       return str;
    }
}