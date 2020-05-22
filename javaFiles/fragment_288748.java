protected void finalize() throws Throwable {
try{
connection.close;
}catch(Exception e){
...
}
}