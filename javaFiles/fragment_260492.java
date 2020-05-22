for (SomeObject obj : getSomeObjects()) {
  Something smth = obj.getSomething();
  if (!smth.isEmpty() && !list.contains(smth)) {
      list.add(smth);
  }
}