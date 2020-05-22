ArrayList<String> desc=new ArrayList<String>();
ArrayList<String> prods=new ArrayList<String>();
SparseArray<ArrayList<String>> vals=new SparseArray<ArrayList<String>>();

 JSONArray arrValues = (JSONArray) jArray.get(0);// first array, descriptions

 System.out.println(" &&&&&&& Arr ====>"+arrValues);

 for (int j = 0; j < arrValues.length(); j++) 
 {
     String value = (String) arrValues.get(j);
     desc.add(value);
     System.out.println(" &&&&&&& ArrValues====>"+value);
 }

 System.out.println(" &&&&&&& desc ====>"+desc);//IMPORTANT. CHECK THE POSITIONS

 for (int i = 1; i < jArray.length(); i++)
 {
     JSONArray arrValues = (JSONArray) jArray.get(i);// second array onwards, values
     prods=new ArrayList<String>();
     System.out.println(" &&&&&&& Arr ====>"+arrValues);

     for (int j = 0; j < arrValues.length(); j++) 
     {
         String value = (String) arrValues.get(j);
         prods.add(value);
         System.out.println(" &&&&&&& ArrValues====>"+value);
     }
     vals.put(i-1, prods);
 }

 // now, 'desc' & 'vals' will do it. Eg:-
for(int i=0;i<vals.size();i++){
     System.out.println("\n"+desc.get(0)+" ::"+vals.get(i).get(0));// for requestID
     System.out.println(desc.get(3)+" ::"+vals.get(i).get(3));// for product
System.out.println(desc.get(5)+" ::"+vals.get(i).get(5));//for currency, and so on..
     }