public class DataQueueListenerExample {
    //This executes our Interrupter after the specified delay.
    public final ScheduledThreadPoolExecutor interruptExecuter = new ScheduledThreadPoolExecutor(1);
    //the dataqueue object.
    protected DataQueue dataqueue;

    public DataQueueEntry read(int wait)
    {
        ScheduledFuture<?> future = null;
        try {
            //create our fail safe interrupter. We only want it to 
            //interrupt when we are sure the read has stalled. My wait time is 15 seconds
            future = createInterrupter(wait * 2, TimeUnit.SECONDS);
            //read the dataqueue
            return this.dataqueue.read(wait);
        } catch (AS400SecurityException e) {
        } catch (ErrorCompletingRequestException e) {
        } catch (IOException e) {
        } catch (IllegalObjectTypeException e) {
        } catch (InterruptedException e) {
            //The read was interrupted by our Interrupter
            return null;
        } catch (ObjectDoesNotExistException e) {
        } finally{
            //Cancel our interrupter
            if(future != null && !future.isDone())
                future.cancel(true);
            Thread.interrupted();//clear the interrupted flag

            interruptExecuter.shutdown();
        }
        return null;
    }


    public ScheduledFuture<?> createInterrupter(long timeout,TimeUnit timeunit)
    {
        return interruptExecuter.schedule(new Interrupter(),timeout,timeunit);
    }

    class Interrupter implements Runnable
    {
        final Thread parent;
        Interrupter()
        {
            this.parent = Thread.currentThread();
        }

        @Override
        public void run() {
            parent.interrupt();
        }
    }
    }