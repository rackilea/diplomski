InitialContext ic = new InitialContext();
Queue[] qs = new Queue[count];
for (int i = 0; i < count; i++) {
  String name = "queue/queuename" + i;
  qs[i] = (Queue) ic.lookup(name);
}