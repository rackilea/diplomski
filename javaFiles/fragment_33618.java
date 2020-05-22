public static void main(String args[]){
     while(true){
          Process proc = Runtime.getRuntime().exec("java yourclasshere");
          try{
               proc.waitFor();
          } catch (InterruptedException e) {}
     }
}