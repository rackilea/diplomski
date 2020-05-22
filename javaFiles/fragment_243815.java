static class Papa{
    Papa(){
        System.out.println("Papa called..");
    }
}
static class Student extends Papa implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 8667392485783922740L;

    String name;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public Student() {
        System.out.println("Constructor called");
    }

}