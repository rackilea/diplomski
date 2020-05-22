<%
    String brands="";
    String userBrands[];
    String brandslist[]= {"bat", "cat", "ant", "batting", "antenna"};

    if(user.get("brand")!=null && !user.get("brand").isEmpty()){
    brands = user.get("brand").toLowerCase();
    System.out.println("BRANDS: " + brands);      
    userBrands = brands.split(",");
    }

     //out.println(Arrays.toString(userBrands));

    // to check if value there or not
    boolean found;        
    for(int i= 0 ;i<brandslist.length ;i++){
          found = false;
     for(int j= 0 ;j<userBrands.length ;j++){
        if(userBrands[j].equals(brandslist[i].toLowerCase().trim())){ %>
   <option selected='selected' value='<%=brandslist[i].toLowerCase().trim()%>'><%=brandslist[i].trim()%></option>
       <%
             //value there 
            found = true;
        }


    }
       //value not there found will remain false and below code will get executed
        if(!found){ %>
  <option value='<%=brandslist[i].trim().toLowerCase()%>'><%=brandslist[i].trim()%></option>
        <%}
    }%>