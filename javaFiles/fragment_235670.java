class Demo {
    public static void main (String args[]){
        A a = new B();
        if(a instanceof B) {
          System.out.println("Yes it is");
        }    
    }
}