class Player {

 States currentState=States.STARTMENU;

 void doSomething() {
  switch (currentState) {
   case STARTMENU:...;
   case PLAYERONEMENU:...;
   //etc
  }
 }

 void playMenu() {
  if (currentState==States.PLAYMENU) {...}
 }
}