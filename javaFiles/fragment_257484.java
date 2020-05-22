setModifier(myEnum, () -> modifier = 1.1, a, b, c, d);

public <E extends Enum<E>> void setModifier(E current, Runnable action, E... allowed) {
  Arrays.stream(allowed)
      .filter(one -> one == current)
      .findAny()
      .ifPresent(found -> action.run());
}