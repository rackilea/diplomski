Lowest = MaxInt;
loop 100x 
  loop million times
     Clock.Start;
     DoTest;
     Timing = Clock.Time;
     if (timing < Lowest) {Lowest = timing}