static int prio_init() {
   if (ThreadPriorityPolicy == 1) {
     // Only root can raise thread priority. Don't allow ThreadPriorityPolicy=1
     // if effective uid is not root. Perhaps, a more elegant way of doing
     // this is to test CAP_SYS_NICE capability, but that will require libcap.so
     if (geteuid() != 0) {
       if (!FLAG_IS_DEFAULT(ThreadPriorityPolicy)) {
         warning("-XX:ThreadPriorityPolicy requires root privilege on Linux");
       }
       ThreadPriorityPolicy = 0;
     }
   }
   return 0;
 }