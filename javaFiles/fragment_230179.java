int[] count = new int[arrayname.length];
for(int i = 0 ; i < arrayname.length; i++){
     count[i] = arrayname[i].replaceAll("[^a-zA-Z]", "").length();
}
//count[0] holds the size of the first name
//count[1] holds the size of the second name
//...