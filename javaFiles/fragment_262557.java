protected ArrayList<HashMap<String, String>>      
setListOrderByName(ArrayList<HashMap<String, String>> menuItems2) {

Collections.sort(menuItems2, new Comparator<HashMap<String, String>>() {
DateFormat f = new SimpleDateFormat("dd/MM/yyyy '@'hh:mm a");//do determ    

@Override
public int compare(HashMap<String, String> mapping1,
    HashMap<String, String> mapping2) {
try {
    return f.parse(mapping1.get(KEY_NAME)).compareTo(f.parse(mapping2.get(KEY_NAME)));
} catch (ParseException e) {
    throw new IllegalArgumentException(e);
}
}
});
return menuItem2;
}