once {
   state = new StartState(when(event1))
   until(event3) {
      state = new AccumulateState(when(event2))
   }
   do_something()
}