public void tf1(GTextField source, GEvent event) {
  if (event.getType().equals("LOST_FOCUS")) {
    state=2;
  }
}

public void tf2(GTextField source, GEvent event) {
  if (event.getType().equals("LOST_FOCUS")) {
    state=2;
  } 
}