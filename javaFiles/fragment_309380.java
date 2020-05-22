for (ArrayList<String> list: al)
 {
    String[] testing = list.toArray(new String[0]); // or (String[]) arr.toArray();
    for(int i=0;i<testing.length;i++) 
     { %> 
        <option value="<%=testing[i]%>"><%=testing[i]%></option><% 
     }
 }