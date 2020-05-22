boolean shouldBreak = false;
while( ... ) {
  if( ... ) {
    shouldBreak = true;
    break; // break out of the while.
  }
}
if(shouldBreak) {
  break; // break out of the switch/case.
}