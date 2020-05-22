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
strength = str                                      |                           .
speed = spd;                                        |       !!right thread wakes up and takes the focus!!
                                                    |   
                                                    |   if(w == null) {
                                                    |       Thread.sleep(500);
                                                    |   } else {
                                                    |       //this doesn't happen, since w is still null
                                                    |   }
                                                    |   
                                                    |           ...right thread goes back to sleep...
name = n;                                           |                           .
specialty = spc;                                    |                           .
-- control exits constructor of Worker --           |                           .
w = newWorker;                                      |       !!right thread wakes up and takes the focus!!
                                                    |       
                                                    |   if(w == null) {
                                                    |       //this doesn't happen, since w is NOT null anymore
                                                    |   } else {
                                                    |       w.do();
                                                    |   }
                                                    |