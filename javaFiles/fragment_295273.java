public class Person 
{
    public static Person [] persons = new Person [3];  // so that every method can access this array
    private String name;
    private int height;
    private int age;  

    public void Person (String name, int height, int age){
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName (){
        return name;
    }

    public int getHeight (){
        return height;
    }

    public int getAge (){
        return age;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setHeight (int height) {
        this.height=height;
    }

    public void setAge (int age) {
        this.age=age;
    }

    public static void selectionSort(Person persons[])
    {
        int smallest;

        for(int i = 0; i < persons.length; i++)
        {
            smallest=i;
            for(int index = i+1; index<persons.length; index++)
                if(persons[index].age<persons[smallest].age)
                    smallest=index;

            swap(i,smallest);   
        }
    }

    public static void swap(int frst, int scnd)
    {
        Person temporary = persons[frst];
        persons[frst] = persons[scnd];
        persons[scnd] = temporary;
    }

    public static void main(String[] args) 
    {
        persons [0] = new Person ();
        persons [0].setName("Josef");
        persons [0].setHeight(170);
        persons [0].setAge(35);

        persons [1] = new Person ();
        persons [1].setName("Marie");
        persons [1].setHeight(160);
        persons [1].setAge(31);

        persons [2] = new Person ();
        persons [2].setName("Karel");
        persons [2].setHeight(180);
        persons [2].setAge(40);

        for (int i=0; i<persons.length; i++){
            System.out.println("Jmeno: " + persons[i].getName()+ ", vek: " + persons[i].getAge() + ", vyska: " + persons[i].getHeight());
        }

        selectionSort(persons);
        for (int i = 0; i<persons.length; i++){
            System.out.println(persons[i].age);
        }
    }
}