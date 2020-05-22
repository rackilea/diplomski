public int compare(String o1, String o2) {
    scoreWord sc1 = new scoreWord((String)o1);
    scoreWord sc2 = new scoreWord((String)o2);
    return i1 > i2 ? 1
         : i1 < i2 ? -1
         : 0;
}