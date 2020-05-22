Scanner scanner = null;
try {
  scanner = new Scanner(new File(file));

  String s1 = null;
  String id= null;
  String[] tempArr = null;
  String searchStr = "\""+search_field.getText()+"\"";
  System.out.print("searchStr = " + searchStr );

  while(scanner.hasNext()) { // While there are more lines in file 
    s1= scanner.nextLine();
    tempArr = s1.split(","); // use coma_delimiter instead coma_delimiter if coma_delimiter=","
    id = (tempArr != null && tempArr.length > 0? tempArr[0] : null);
    System.out.print("ID = " + id);

    if(id != null && id.equals(searchStr)) {
      System.out.print("OKOK");
      break; // quit the loop searchStr is found
    } else {
    System.out.println("NOK");
    }
  }
} catch (FileNotFoundException fe) {
 fe.printStackTrace();
} finally {
  scanner.close();
}