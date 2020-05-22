boolean enoughLetters(Map<Character, Integer> magMap, Map<Character,Integer> ransomMap) {
    for( Entry<Character, Integer> e : ransomMap.entrySet() ) {
        Character letter = e.getKey();
        Integer available = magMap.get(letter);
        if (available == null || e.getValue() > available) return false;
    }
    return true;
}