int total_count = 0;
for(int j=0; j<10; j++){
    System.out.println("The outer loop has iterated " + String.valueOf(j+1) + " times!"); 
    System.out.println("Executing the inner loop");   
    int local_count = 0;
    for(int k=10; k>0; k--){
        local_count ++;
        total_count ++;
        System.out.println("Inner loop #" + String.valueOf(j+1) + " has iterated " + String.valueOf(local_count) + " times!");
        System.out.println("The inner loop's total iterations are " + String.valueOf(total_count) + " times!");
    }
}
System.out.println("The nested loop iterated " + String.valueOf(total_count) + " times!");