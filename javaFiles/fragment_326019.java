import java.util.ArrayList;

public class Fighter {

    private String name;

    private static String[] names = { "Terminator", "Slicer","Ninja", 
             "cow", "Robot", "littlegirl" };
    private static int id = 0;
    private static ArrayList<String> usedNames = new ArrayList<String>();


    public void Fighters(){
        id++;
        String checkedName = "";
        do{
            checkedName = names[(int) (Math.random() * names.length)];
            if(!usedNames.contains(checkedName)) break;
        }
        while(true);
        name = checkedName;
        usedNames.add(name);
    }

    public String toString(){
        return String.format(id+" Name:%-5s, name");
    }

}