public class ListTracAddedAndRemoved {

public static void main(String[] args) {
ArrayList<String> old = new ArrayList<String>();
old.add("a");
old.add("b");
old.add("c");

ArrayList<String> newOne = new ArrayList<String>();
newOne.add("b");
newOne.add("d");
newOne.add("e");

ArrayList<String> removed = new ArrayList<String>();
for (String oldString : old) {
    if(!newOne.contains(oldString)){
    removed.add(oldString);
    }
}

ArrayList<String> newAdded = new ArrayList<String>();
for (String newString : newOne) {
    if(!old.contains(newString)){
    newAdded.add(newString);
    }
}

System.out.println("Removed: "+removed.toString());
System.out.println("NewAdded: "+newAdded.toString());
}
}