public static boolean doesKeyStringOccursEarlyInDict(String string,String key){
    int i = Math.min(string.length(), key.length());
    int j = 0;
    while(j<i){
        if(string.charAt(j) > key.charAt(j)){
            return true;
        }
        j++;
    }
    //else return false as either both were equal or key does not come early in dictionary
    return false;
}

public static void insertionSort(String[] s){
    for(int i=1;i<s.length;i++){
        String key = s[i];
        int j = i-1;
        while(j>=0 && doesKeyStringOccursEarlyInDict(s[j], key)){
            s[j+1] = s[j];
            j--;
        }
        s[j+1]=key;
    }
}
public static void main(String[] args) {
    //read the file each line
    //split it and store it in an arraylist of string as it can grow..repeat it till u have read all the content 
 ArrayList<String> s = new ArrayList<>();
    //get the complete string array
    String[] stringarr = (String[]) s.toArray();
    //example : String[] stringarr = {"def","xyz","abc","aaa"};
    insertionSort(stringarr);
    for(String words:stringarr)
    System.out.println(words);
}