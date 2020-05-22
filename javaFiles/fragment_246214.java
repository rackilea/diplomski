public static void main(String args[]){
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(5);
    list1.add(6);
    JSONObject outerObject = new JSONObject();
    JSONArray outerArray = new JSONArray();
    List<Integer> duplicateValue=new ArrayList<Integer>();
    JSONObject [] innerObject = new JSONObject[list1.size()];
            for (int  i = 0; i < list1.size(); i++)// change to list1.size()
                {
                    JSONArray inerArray = new JSONArray();
                    innerObject[i]=new JSONObject();
                    innerObject[i].put("Item" , list1.get(i));
                    if(list1.get(i)%2==0)
                    {
                        innerObject[i].put("Odd or Even", "number "+list1.get(i)+" is even");
                    }
                    else{
                        innerObject[i].put("Odd or Even", "number "+list1.get(i)+" is odd"); 
                    }
                    for (int j=i; j < list1.size(); j++)
                    {
                        if(list1.get(j)!=list1.get(i)){
                            if (list1.get(j)%list1.get(i)==0){
                                    if(!duplicateValue.contains(list1.get(j))){
                                    inerArray.add(list1.get(j));
                                    duplicateValue.add(list1.get(j));
                                }
                            }
                        }
                    }
                    if(inerArray.size()!=0){
                        innerObject[i].put("Multiplication" , inerArray);
                    }
                    outerArray.add(innerObject[i]);
                }

            outerObject.put("rows", outerArray);
            System.out.println(outerObject.toString());
}