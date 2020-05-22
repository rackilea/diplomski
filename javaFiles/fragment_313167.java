/* Static */
class Hello {
    public static MyObj an_obj;
    public static void main(String[] args) { 
        setObj();
    }           

    public static void setObj() {
        this.an_obj.set_size(7);
        say("size is " + this.an_obj.get_size());
    }
}

/* Non-Static */
class Hello {
    public MyObj an_obj;
    public static void main(String[] args) {
        Hello hello = new Hello(); 
        hello.setObj();
    }           

    public void setObj() {
        this.an_obj.set_size(7);
        say("size is " + this.an_obj.get_size());
    }
}