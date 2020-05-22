enum Type {
  I(IBlock::new), L(LBlock::new), ...;

  private Supplier<? extends Block> supplier;
  private Type(Supplier<? extends Block> supplier) {
    this.supplier = supplier;
  }

  public Block getBlock() {
    return supplier.get();
  }