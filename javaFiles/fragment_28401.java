List<GameEntry> arr = new ArrayList<>();
Comparator<GameEntry> cmp = Comparator.comparingInt(a -> a.getScore());

public void add(GameEntry e) {
  arr.add(e);
  Collections.sort(arr, cmp.reversed());
  while(arr.size() > capacity) {
    arr.remove(arr.size()-1);
  }
}