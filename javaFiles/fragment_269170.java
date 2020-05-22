private static final AtomicBoolean hasRunAtom = new AtomicBoolean();

public void method() {
  if (hasRunAtom.getAndSet(true)) return;
  [block instructions]
}