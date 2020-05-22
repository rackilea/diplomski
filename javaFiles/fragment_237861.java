public static void testArray(int ... a)
{ 
    for(int i:a)
        if(i==10)
            System.out.println("Number 10 exists !");
}

testArray(5, 10, 15);