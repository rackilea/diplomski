public static void main(String[] args) {
    String sampleContent = "hello ; hai ; come fast ;";
    String SQLScripts[] = sampleContent.split("(?<=;)",-1);
    System.out.println("SQLSCript Length is:"+SQLScripts.length);
    for(int m=0;m<SQLScripts.length-1;m++){
        System.out.println("After SQLScripts spliting with semi colon is : "+SQLScripts[m]);
    }
  }