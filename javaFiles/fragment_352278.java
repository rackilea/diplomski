List<String> sequences = Arrays.asList("1539638833","6755549201","6443783956","2424553477","1563499332","0279453983");
Map<String,Integer> count = new HashMap<>();
for (String seq : sequences) {
    int length = seq.length();
    for (int i=0 ; i<length - 2 ; i++) {
        String sub = seq.substring(i,i + 3);
        count.put(sub,count.containsKey(sub) ? count.get(sub) + 1 : 1);
    }
}
System.out.println(count);