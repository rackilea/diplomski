Iterator<String> iterator = nameList.iterator();
Set<String> removed = new HashSet<>();
while(iterator.hasNext()){
    String s = iterator.next();
    if (!removed.contains(s)) {
        removed.addAll(work(s));
    }
}
list.removeAll(removed);