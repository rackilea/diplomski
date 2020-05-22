386       private void sched(TimerTask task, long time, long period) {
387           if (time < 0)
388               throw new IllegalArgumentException("Illegal execution time.");
389   
390           // Constrain value of period sufficiently to prevent numeric
391           // overflow while still being effectively infinitely large.
392           if (Math.abs(period) > (Long.MAX_VALUE >> 1))
393               period >>= 1;
394   
395           synchronized(queue) {
396               if (!thread.newTasksMayBeScheduled)
397                   throw new IllegalStateException("Timer already cancelled.");
398   
399               synchronized(task.lock) {
400                   if (task.state != TimerTask.VIRGIN)
401                       throw new IllegalStateException(
402                           "Task already scheduled or cancelled");
403                   task.nextExecutionTime = time;
404                   task.period = period;
405                   task.state = TimerTask.SCHEDULED;
406               }
407   
408               queue.add(task);
409               if (queue.getMin() == task)
410                   queue.notify();
411           }
412       }