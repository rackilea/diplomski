public static void f(Integer b){      
        b.setValue(3);      
    }      
    public static void main(String[] args){      
        Integer a=0;      
        f(a);      
        System.out.println(a);      
  }