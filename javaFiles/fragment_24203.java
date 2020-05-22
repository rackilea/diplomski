List<?> origA;
List<?> origB;

List<?> newA = new ArrayList<?>(origA);
List<?> newB = new ArrayList<?>(origB);

Collections.sort(newA);
Collections.sort(newB);

// do mods