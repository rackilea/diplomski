public static int findFreq(String[] arr,char c) {
    Map<Character,Integer> map  = new HashMap<Character,Integer>();
    for(int i=0;i<arr.length;i++) {
        for(Character ch : arr[i].toCharArray()){
            if(map.containsKey(ch)) 
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch, 1);
        }
    }
    return map.get(Character.valueOf(c));
 }