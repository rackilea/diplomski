try {
   Runtime rf = Runtime.getRuntime(); 
   Process pf = rf.exec("msiexec /i \"\\IE8fix.msi\"");    
} catch(Exception e) {                 
   //System.out.println(e.toString()); // not necessary       
   e.printStackTrace();
}