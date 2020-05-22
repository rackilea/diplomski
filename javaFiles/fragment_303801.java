void foo() {
  DataHelper dh = DataHelper.getInstance(listener1);
  bar();
  // dh.listener no longer points to listener1
}

void bar() {
  DataHelper dh = DataHelper.getInstance(listener2);
}