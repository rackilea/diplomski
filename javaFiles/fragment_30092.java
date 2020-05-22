public enum MyEnum {
    VALUE1("value.1"),
    VALUE2("value.2");

    private String id;

    private MyEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    public static MyEnum fromId(String id){
        for(MyEnum e:MyEnum.values()){
            if(e.getId().equals(id)){
                return e;
            }
        }
        throw new RuntimeException("Enum not found");
    }

    public static void main(String[] args) {
        String value = "value.2";
        switch(MyEnum.fromId(value)){
        case VALUE1:
            System.out.println("ID 1");
        break;
        case VALUE2:
            System.out.println("ID 2");
            break;
        }
    }
}