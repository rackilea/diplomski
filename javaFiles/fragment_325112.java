interface TimerOberserver{
   notify();
}

class ObserverClass implements TimerListener{ ...

class Timer {
  List<TimerListener> allListeners;

  //notfy all listeners 

}