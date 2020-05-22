static class DataType {

    String Name;
    int Age;

    public DataType(String name, int age) {
        Name = name;
        Age = age;
    }

    public DataType(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object fromObj) {
        DataType dt = (DataType)fromObj;

        if(Name == null) return false;
        if(dt.Age == Age) return true;
        if(dt.Name.equals(Name)) return true;

        return false;
    }
}