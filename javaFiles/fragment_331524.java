while (s.hasNextLine()) {
   String line = s.nextLine().replace(":",",");
   String[] data =line.split(",");
   //...Multiple if statements searching for different keywords
   else if(data[0].equals("WarningGeotask:")){
      WarningGeotask warningGeotask = new WarningGeotask(Integer.parseInt(data[1].trim()), Integer.parseInt[data[2].trim());
   }