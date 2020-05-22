void addqueue(String name){ 
    System.out.println("Enter Queue Item :"); 
    qitems[end] = name; 
    if(end==5){ 
        takequeue(name); 
    } 
    end++;
}