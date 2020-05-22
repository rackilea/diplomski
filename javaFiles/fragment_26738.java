ArrayList orgArrList = (java.util.ArrayList)domainUserObj.getOrganizations();

for(int i = 0 ; i < orgArrList.size(); i++) {
    System.out.println("For getOrganizations ::"+orgArrList.get(i));                
    ArrayMap<String,String> orgMapArr = (ArrayMap<String, String>)
                                         orgArrList.get(i);
    System.out.println("ArrayMap-UserOrganization ::"+orgMapArr);           
    for(int index=0; index < orgMapArr.size();index++) {
    try {
        System.out.println(orgMapArr.getKey(index) + " "
                                   + orgMapArr.getValue(index));
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}