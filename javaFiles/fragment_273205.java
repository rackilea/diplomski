int goTo=0;
while(true){
  switch(goTo){
  case 0:
    doSomething();
    goTo = 1;
    continue;
  case 1:
    doSomethingElse();
    goTo = 2;
    continue;
  case 2:
    doSOmethingDifferent();
    goTo = 0;
    continue;
  default:
    return;
  }
}