ResultSet resultset = ...;
ArrayList<String> arrayList = new ArrayList<String>(); 
while (resultset.next()) {              
        int i = 1;
        while(i <= numberOfColumns) {
            arrayList.add(resultset.getString(i++));
        }
        System.out.println(resultset.getString("Col 1"));
        System.out.println(resultset.getString("Col 2"));
        System.out.println(resultset.getString("Col 3"));                    
        System.out.println(resultset.getString("Col n"));
}