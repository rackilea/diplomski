int max = 100;

for (int i = 1; i <= max; i++){ 
    if (i % 3 == 0 && i % 5 == 0){ 
        System.out.println("CracklePop"); 
    } else  if (i % 3 == 0) { 
        System.out.println("Crackle"); 
    } else if(i % 5 == 0){ 
        System.out.println("Pop"); 
    } else {
        System.out.println(i); 
    }
}