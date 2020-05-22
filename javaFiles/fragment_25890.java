class ListItem<T> {
}

abstract class ListView<T> {
  abstract void render(final ListItem<T> item);
}

class CommonListView<T> extends ListView<T> {

  private final Consumer<T, ListItem<T>> itemConsumer;

  CommonListView(Consumer<T, ListItem<T>> itemConsumer) {
    this.itemConsumer = itemConsumer;
  }

  @Override
  void render(ListItem<T> item) {
    itemConsumer.accept(item);
  }
}

interface Consumer<T, E extends ListItem<T>> {
  void accept(E item);
}