String[] arr = new String[]{"apple", "banana", "mango", "melon"};
List<List<String>> arrs = new ArrayList<List<String>>();
char f = 0;
List<String> last = null;
for(String s : arr){
    if( f != s.charAt(0) ){
        f = s.charAt(0);
        // since first the char is different, create a new array
        last = new ArrayList<String>();
        last.add(s);
        if( last != null ){
            arrs.add(last);
        }
    }
    else {
        last.add(s);
    }
}