Worker:        if (runState < STOP &&    // true for now

shutdownNow:   if (state < STOP)
shutdownNow:       runState = STOP;      // set new state
shutdownNow:   for (Worker w : workers) {
shutdownNow:       w.interruptNow();     // interrupt      
shutdownNow:   }

Worker:              Thread.interrupted() &&   // clears interrupted state 
Worker:              runState >= STOP)         // but we have double check
Worker:            thread.interrupt();         // that will setup it again