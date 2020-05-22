void myMethod(){
  final String VOLUME="D:";
  final String DIRECTORY_A_PATH=VOLUME+File.separator+"myJAVA";
  final String DIRECTORY_B_PATH=DIRECTORY_A_PATH+File.seperator+"javasbc";
  final String FILE_PATH=DIRECTORY_B_PATH+File.seperator+"SchoolBell.avi";

  File f0=new File(DIRECTORY_A_PATH);
  if(!f0.exists()){System.out.println(DIRECTORY_A_PATH+" does not exist");  

  return;
}

  File f1=new File(DIRECTORY_B_PATH);
  if(!f1.exists()){System.out.println(DIRECTORY_A_PATH+" does not exist"); 

  return;
}

  File f2=new File(FILE_PATH);
  if(!f2.exists()){System.out.println(FILE_PATH+" does not exist"); 
  return;
}



}