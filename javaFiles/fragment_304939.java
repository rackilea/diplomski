Scanner scanner = new Scanner(new FileReader("C:/workspace/column-mapping.txt"));
Map<String, String> personMap = new LinkedHashMap<String, String>();
Map<String, String> automobilMap = new LinkedHashMap<String, String>();

String line;
boolean person = false;
boolean automobil= false;

while (scanner.hasNext()) {
     line = scanner.next();
     if(line.startsWith("#Person") && !line.isEmpty()){
        line = scanner.next();
        person = true;
        automobil = false;
     }

     if(line.startsWith("#Automobil") && !line.isEmpty()){
        line = scanner.next();
        automobil = true;
        person = false;
     }

     if(person){
        if (!line.startsWith("#") && !line.isEmpty()) {
            String[] columns = line.split("=");
            for(String str:columns){
                 System.out.println(str);
            }
            personMap.put(columns[0], columns[1]);
        }
     }

     if(automobil){
         if (!line.startsWith("#") && !line.isEmpty()) {
             String[] columns = line.split("=");
             for(String str:columns){
                  System.out.println(str);
             }
             automobilMap.put(columns[0], columns[1]);
         }
      }



}
System.out.println("personMap"+personMap);
System.out.println("automobilMap"+automobilMap);