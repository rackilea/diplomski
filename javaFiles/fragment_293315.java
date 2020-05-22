List<Looper> allLoopers = new ArrayList<Looper>();

...

allLoopers.addAll(looperTracks);
allLoopers.add(this);

for(Looper looper : allLoopers) {
  ...
}