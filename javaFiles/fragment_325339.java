list1.populate();
list2.populate(); 
list1.addAll(list2); 

Gson gson = new GsonBuilder().create(); 
gson.toJson(list1);