public class MyCoffe {

    public static class Builder {
        private MyCoffe instance;

        public Builder() {
            this.instance = new MyCoffe();
        }

        public Builder setName(String name) {
            this.instance.name = name;
            return this;
        }

        public Builder setId(int id) {
            this.instance.id = id;
            return this;
        }

        public MyCoffe build() {
            if (this.instance.name == null) {
                throw new AppropriateException("'name' is required");
            }
            if (this.instance.id == 0) { // Assumes 0 isn't a valid ID
                throw new AppropriateException("'id' is required");
            }
            return this.instance;
        }
    }

    private String name;
    private int id;

    private MyCoffe() {
    }

    public MyCoffe(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString(){
        return name + "/" + id;
    }

    public static void main(String[] args){
        MyCoffe myCoffe = new MyCoffe.Builder().setName("HelloWorld").setId(9999).build();
        System.out.println(myCoffe);

        System.out.println("Thanks for help!");
    }
}