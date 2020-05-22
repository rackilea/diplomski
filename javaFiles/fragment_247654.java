public static void main(String[] args) {
    ArrayList<ImageList> list = new ArrayList<>();
    list.add(new ImageList()); //adding some dummy objects, you add yours
    list.add(new ImageList());
    String[] strNames = new String[list.size()];
    for(int j=0; j < strNames.length; j++){
         strNames[j] = String.valueOf(list.get(j));
         Log.d("String : {} ", strNames[i]);
    }
 }