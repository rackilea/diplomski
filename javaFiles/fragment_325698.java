void addqueue(String name){ 
    System.out.println("Enter Queue Item :"); 
    qitems[end] = name; 
    end++;
    if(end>=5){ 
        takequeue(name); 
    } 
}