//before read/writing shared data
(*env)->MonitorEnter(obj);

...                      /* synchronized block */

//after read/writing shared data
(*env)->MonitorExit(obj);