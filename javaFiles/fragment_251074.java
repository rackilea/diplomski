ClassB { 
    public static void main(String[] args) { 
        System.out.println("ClassB main() Called"); 
    } 
} 

ClassA { 
    public static void main(String[] args) { 
        System.out.println("ClassA main() Called"); 
        ClassB.main(args); 
    } 
}