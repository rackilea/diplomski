public class ReadXml {

    public void doSomeThing(){

    File file = new File("PageOutput.txt");
    FileOutputStream fos = new FileOutputStream(file);
    PrintStream ps = new PrintStream(fos);

    XmlParser read = new XmlParser();
    List<Item> readConfig = read.readConfig("UnderMaintenanceConfig.xml");

    for (Item item : readConfig)
    {
        System.setOut(ps);
        System.out.println(item);
    }


  }
}