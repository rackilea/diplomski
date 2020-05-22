//if you have an instance of the adapter...
int index = 5;  //or whatever index you want
HashMap<String,String> mHashMap = adapter.getItem(index);


//if you are inside of the MyCustomAdapter class...
int index = 5;
HashMap<String,String> mHashMap = getItem(index);