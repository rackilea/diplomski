class SimpleUser{
    String name;int age;
    SimpleUser(String name,int age){this.name=name;this.age=age;}
    public String toString(){return name+" "+age;}

    public boolean equals(Object obj) {return name.equals(((SimpleUser)obj).name);};

    public int hashCode() {return name.hashCode();};
}