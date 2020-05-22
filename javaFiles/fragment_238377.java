left thread                                         | right thread
----------------------------------------------------|-----------------------------------------------------
                                                    |
Worker newWorker = new Worker(                      |               ...right thread sleeps...
                    4,                              |                           .
                    5.2f,                           |                           .
                    "mmayilarun",                   |                           .
                    "multithreaded programming"     |                           .
                );                                  |                           .
-- control jumps to constructor of Worker --        |                           .
w = this;   // danger!!                             |                           .
strength = str;                                     |                           .
speed = spd;                                        |       !!right thread wakes up and takes the focus!!
                                                    |   
                                                    |   if(w == null) {
                                                    |       //this doesn't happen, since w is NOT null at this point
                                                    |   } else {
                                                    |       w.do(); //here, w is not yet a fully initialized object,
                                                    |       //and the output is not the expected (if it works at all)
                                                    |   }
                                                    |   
                                                    |           ...right thread goes back to sleep...
name = n;                                           |                           .
specialty = spc;                                    |                           .
-- control exits constructor of Worker --           |