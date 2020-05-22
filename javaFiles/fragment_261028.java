public void foo(int currNum) {
  if (currNum > 5) 
    return;
  println(currNum);
  foo(currNum + 1);
}