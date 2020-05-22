class MsProjectTaskData {
    private final String firstname;
    private final String lastname;
    private final int age;

    private MsProjectTaskData(Builder builder){
        this.firstname = builder.firstname;
        this.lastname  = builder.lastname;
        this.age       = builder.age;
    }

    public static final class Builder{
        //fields that are REQUIRED must be private final
        private final String firstname;
        private final String lastname;

        //fields that are optional are not final
        private int age;

        public Builder(String firstname, String lastname){
            this.firstname = firstname;
            this.lastname  = lastname;
        }

        public Builder(MsProjectTaskData data){
            this.firstname = data.firstname; 
            this.lastname  = data.lastname;
        }

        public Builder age(int val){
            this.age = val; return this;
        }

        public MsProjectTaskData build(){
            return new MsProjectTaskData(this);
        }
    }

    public String getFirstname() {
         return firstname;
    }

    public String getLastname() {
         return lastname;
    }

    public int getAge() {
         return age;
    }
}