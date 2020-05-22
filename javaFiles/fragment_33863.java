// Put the current thread in Waiting State
Synchronized(sharedInstance) {
   sharedInstance.Wait()
}

// Wakes up all the thread sharing sharedInstance
Synchronized(sharedInstance) {
   sharedInstance.NotifyAll()
}