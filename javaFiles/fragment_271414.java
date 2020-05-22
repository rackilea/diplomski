try{//do something
}
catch (RuntimeException e) {
    throw e;
} 
catch (Exception e) {
    throw new RuntimeException(e);
}