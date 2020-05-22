void synchronized incIBy5() {
  i += 5 
}

void incIBy5() {
  synchronized(this) {
    i += 5 
  }
}

void incIBy5() {
  synchronized(this) {
    int temp = i;
    i = temp + 5;
  }
}