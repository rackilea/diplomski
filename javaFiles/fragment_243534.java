public class ArrayListExp{
    public static void main (String[] args){

        ArrayList<String> name = new ArrayList<String>();

        name.add("Chris");
        name.add("Lois");
        name.add("Meg");
        name.add("Meg");
        name.add("Brain");
        name.add("Peter");
        name.add("Stewie");

        System.out.println(name);

        for ( int i = 0;  i < name.size(); i++){
            String oldName = name.get(i);
            if(oldName.equals("Meg"))
            {
                name.remove(i);
                i--;
            }
        }

        System.out.println(name);
    }
}