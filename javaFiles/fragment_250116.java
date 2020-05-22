Deque<?> d = fillWithString();

for (Object i : d) {
    System.out.print(i + " ");
}

d = fillWithInt();

for (Object i : d) {
    System.out.print(i + " ");
}

private Deque<String> fillWithString() {
  Deque<String> d = new Deque<String>();
  d.pushLeft("Datastructuren");
  d.pushLeft("is");
  d.pushRight("heel");
  d.pushRight("leuk");
  d.pushLeft("of");
  d.pushRight("niet?");
  d.changeLeft(5, "test");
  d.changeRight(3, "een");
  d.changeLeft(2, "Dit");
  d.changeRight(4, "is");
  d.popRight();
  d.popLeft();
  return d;
}

private Deque<Integer> fillWithInt() {
  Deque<Integer> d = new Deque<Integer>();
  d.pushLeft(67);
  d.pushLeft(1);
  d.pushLeft(13);
  d.pushRight(18);
  d.pushRight(10);
  d.pushRight(2);
  d.pushLeft(29);
  d.pushRight(88);
  d.changeLeft(5, 25);
  d.changeRight(1, 17);
  d.popRight();
  d.changeLeft(8, 18);
  d.changeRight(5, 19);
  d.popLeft();
  return d;
}