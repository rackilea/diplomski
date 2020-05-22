for(Character c : msg2.toCharArray()){
    if(!hMap.containsKey(c)){
        return false;
    }else{
        int freq = hMap.get(c) - 1;
        if (freq < 0)
            return false;
        hMap.put(c, freq - 1);
    }
}