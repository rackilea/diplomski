public class myTableModel{
 private String somePropertyName1;
 .
 .
 .
 private String somePropertyNameN;

 public MyTableModel(String ... array){
    //assign values to instance attributes.
 }
  //getters and setters

}


//remember method names in java starts with lower-case
public List<MyTableModel> infoForTheTable() {
    List<MyTableModel> data = new ArrayList<>(); //diamond inference
    //use try-with-resources
    try (Scanner s = new Scanner(Paths.getPath("info.txt"))){            
        while (s.hasNextLine()) {
          String line = s.nextLine();
          if (line.startsWith("")) {
            String[] atoms = line.split("[#]");
            data.add(new MyTableModel(atoms[0],atoms[1],atoms[2],atoms[3],atoms[4],atoms[5]));
         }
        }
    }
    catch(IOException e) {
        //handle exception or throw it up!
    }
        return data;
    }