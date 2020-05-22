public List feedResultIntoList(List<String> myList , ResultSet rs){

        if(rs == null || myList == null)
        return null;

        else{

        while (rs.next()) {        
                 myList.add(rs.getString("columnName"));
        }
        System.out.println(myList);
        return myList;
        }
}