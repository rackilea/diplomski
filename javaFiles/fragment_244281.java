public static List<tcmb> getList(Activity a){

    // your code
    // 

    List<String> itemList = new ArrayList<String>();
    itemList.addAll(Arrays.asList(itemWords));
    dovizList = (List)itemsList;
    Log.d(TAG, "getValuestcmb: " + dovizList.size());

    return dovizList;