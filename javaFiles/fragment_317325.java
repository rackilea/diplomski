List <String> unholyBible = new ArrayList <String>();
unholyBible.add("armageddon");
unholyBible.add("abyss");
unholyBible.add("Abaddon");
unholyBible.add("Antichrist");
Collections.sort(unholyBible, new Comparator <String>() {
    public int compare(String o1, String o2){
        return o1.compareToIgnoreCase(o2);
    }
});
System.out.println(unholyBible);