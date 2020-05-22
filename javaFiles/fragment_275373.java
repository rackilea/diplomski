int expectedId = 1;
while (rs.next()) {
    //All your code
    if(expectedId != profileid){
       System.out.println ("Profile id "+expectedId+" to "+(profileid-1)+" missing.";
       expectedId = profileid;
    }
    expectedId++;
}