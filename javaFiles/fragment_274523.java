class Honda4 extends Bike{  
    int model() 
    //long is compatible with int since there is no loss of precision
    {
         return 1234;
    }  

    public static void main(String args[]){  
        Bike obj = new Honda4();  
        System.out.println(obj.model());  
    }  

}