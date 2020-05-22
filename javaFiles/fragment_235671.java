class Demo {
    public static void main (String args[]){
        Object o = new Example();
        if(o instanceof Example) {
          System.out.println("Yes it is");
        }    
    }
}