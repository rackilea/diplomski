class Entry implements Comparable<Entry>{
    public int index;  //proper OOP would require using encapsulation, but for 
    public int value;  //demonstration I'll just use direct variable access

    public int compareTo(Entry e){
        return Integer.compare(value, e.value);
    }
}