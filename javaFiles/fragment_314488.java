public static void main(String[] args) 
     throws FileNotFoundException { 
     Catalog catalog= new Catalog(); 
     catalog.loadList(args[0]);
     System.out.println();
     //System.out.println(toString());                  **I don't know how to call toString**
     // use this line
     System.out.println(catalog.toString());  
     System.out.println();
     System.out.format("Total Price = %9.2f\n", catalog.getTotalPrice());
    }