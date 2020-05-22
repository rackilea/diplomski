connection.setAutoCommit(false);
try{
    insert(1,2);
}
catch(Exception e){
    System.out.println("1, 2 didn't work");
}
try{
    insert(4,5);
}
catch(Exception e){
    System.out.println("4, 5 didn't work");
}
connection.commit();