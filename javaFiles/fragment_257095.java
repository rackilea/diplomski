Runtime runtime = Runtime.getRuntime();      
try { 
    Process p = runtime.exec("start cmd.exe /k \"ghci.exe test.hs\""); 

} catch (IOException ex) {
 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); 
}