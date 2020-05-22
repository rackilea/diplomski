public static void write(item a) {
  //Variable declaration. outp is private instance String array
  outp[0] = "<" + a.getID() + ">\n";
  outp[1] = "<name>" + a.getName() + "</name>";
  outp[2] = "<description>" + a.getDesc() + "</description>\n";
  outp[3] = "<type>" + a.getType() + "</type>\n";
  outp[4] = a.getOtherCode() + "\n";
  outp[5] = "</" + a.getID() + ">\n";

  try {
    //Create/Append data to items.xml located in variable folder.

    FileWriter writeItem = new FileWriter(modTest.modName + File.separator +"items.xml", true); 
    BufferedWriter out = new BufferedWriter(writeItem);

    //Loop through array and write everything 

    for(int i = 0; i < outp.length; i++) {
      System.out.println("outp[" + i + "] = " + outp[i]);
      System.out.println("Writing line " + i + " of item "+  a.getID());
      out.write(outp[i]); 
    }

    out.close();
  }
  catch (Exception e) { System.err.println("Erro: " + e.getMessage()); }
}