MyGeneric<? extends Number> item;
if (choice == 1) {
  item = new MyGeneric<Integer>();
} else {
  item = new MyGeneric<Float>();
}