if (keyPressed) {
   if (!start && (key == 'p' || key == 'P')) {
    start = true;
    _delay = new Delay(5000); //of course, remove this line from where I took it
   }
  }