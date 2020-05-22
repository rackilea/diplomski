private String name;
    private int age;
    private String gender;


    public Customer(String name, int age, String gender){

        this.name = name;
        this.age = age;
       this.gender = gender;

    }


    public static void data(Customer [] customers){
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < customers.length; i++){

            System.out.print("Name: ");
            setName(input.next());

            System.out.print("Age: ");
            setAge(input.nextInt());

            System.out.print("Gender: ");
            setGender(input.next());

            customers[i] = new Customer( getName(), getAge(), getGender());
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender= gender;
    }





    public String toString()
    {
        String result;
        result = name +"         "+ age +"            "+ gender;
        return result;
    }



}