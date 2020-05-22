// this creates an empty list of initial capacity 8
musicLists = new ArrayList<List<Mp3>>(8);
//  musicList.size() is still 0
// we can add as much items as we want, the list will dynamically grow.
for (int i = 0; i < 8; i++) {
    List<Mp3> emptySubList = new ArrayList<Mp3>();
    // emptySubList.size() is 0 each as well.
    musicList.add(emptySubList);
}
//  musicList.size() is 8 now.

// do your stuff...
musicLists.get(listNr).add(new Mp3(id,filename,length));