Iterator<String> iterator = nameList.iterator();
List<String> removed = new ArrayList<>();
while(iterator.hasNext()){
    String s = iterator.next();
    removed.addAll(work(s));
}
list.removeAll(removed);