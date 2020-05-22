int incrementTime(int time) {
      time++;
      int hours = time / 100;
      int minutes = (time - hours * 100) % 60;
      if (minutes == 0) hours++;
      return hours * 100 + minutes;
 }