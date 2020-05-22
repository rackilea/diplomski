public static int matchCount(String s, String find) {
     String[] split = s.split(" ");
     int count = 0;

     for(int i=0; i<split.length; i++){
        if(split[i].equals(find)){
           count++;
        }
     }
     return count;
 }


String s = "stack is stack";
System.out.println(matchCount(s, "stack")); // 2