public static <R extends Recursable> void doStuff(
      List<? extends RecursableAction<R, ?>> actions, R recursable) {
  for(RecursableAction<R, ?> action : actions) {
    action.act(recursable);
  }
}

public static void main(String[] args) {
  List<RecursableAction<Item, IdGeneratorContext>> actions = new ArrayList<>();
  actions.add(new IdGeneratorItemAction());
  doStuff(actions, new Item());
}