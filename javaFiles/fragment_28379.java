private static boolean healthCheck(){
    try{
        driver.getTitle().equals(null); 
    }catch(Exception ex){
        System.out.println("Browser closed");
        return false;
    }

    return true;
}