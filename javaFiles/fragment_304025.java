public static void main(String[] args) {
        try {
           File inputFile = new File("input.txt");
           SAXReader reader = new SAXReader();
           Document document = reader.read( inputFile );

           System.out.println("Root element :" 
              + document.getRootElement().getName());

           Element classElement = document.getRootElement();

           List<Node> nodes = document.selectNodes("/class/student" );
           System.out.println("----------------------------");
           for (Node node : nodes) {
             if("1".equals(node.selectSingleNode("person_types").selectSingleNode("person_type").getText())){
                 System.out.println("\nCurrent Element :" 
                         + node.getName());
                      System.out.println("Student roll no : " 
                         + node.valueOf("@rollno") );
                      System.out.println("First Name : " + node.selectSingleNode("firstname").getText());
                      System.out.println("Last Name : " + node.selectSingleNode("lastname").getText());
                      System.out.println("First Name : " + node.selectSingleNode("nickname").getText());
                      System.out.println("Marks : " + node.selectSingleNode("marks").getText());
             }
           }
        } catch (DocumentException e) {
           e.printStackTrace();
        }
     }