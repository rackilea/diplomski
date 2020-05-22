public class Dog {

    public ArrayList<String> names=new ArrayList<String>();

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public static void main(String[] args){
         Dog dog=new Dog();
         dog.getNames().add("Rover");

         ArrayList<String> someArrayList=dog.getNames();
         someArrayList.add("Rex");

         System.out.println(dog.getNames().contains("Rex")); //prints true. dog's internal state effected from afar

         someArrayList=new ArrayList<String>(); //change someArrayList to refer to a whole new ArrayList
         someArrayList.add("bad");

         System.out.println(dog.getNames().contains("bad")); //prints false, someArrayList now points to a different ArrayList to the one internal to dog

    }

}