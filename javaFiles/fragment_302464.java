while (notDone) { 
  if(interrupted) {
    notDone = false;
   } else {
   doSomething(); 
   Thread.sleep(); 
   }
}