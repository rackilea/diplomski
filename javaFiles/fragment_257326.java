Vector v1;//field

BufferedReader br = null;         
try {
     br = new BufferedReader(new FileReader(new File("test.txt")));
     String line;
     v1=new Vector();
     while ((line = br.readLine()) != null) {
         String[] split = line.split(" ");
         v1.add(split[0]);
          jComboBox1.addItem(split[1]);
     }
      br.close();

 } catch (Exception ex) {
        ex.printStackTrace();
 }