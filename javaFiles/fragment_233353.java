public class TFileTransport extends TTransport {

    public static enum tailPolicy {

      NOWAIT(0, 0),
      WAIT_FOREVER(500, -1);

      /**
       * Time in milliseconds to sleep before next read
       * If 0, no sleep
       */
      public final int timeout_;

      /**
       * Number of retries before giving up
       * if 0, no retries
       * if -1, retry forever
       */
      public final int retries_;

      // ... ctor ...
    }


    /**
     * Current tailing policy
     */
    tailPolicy currentPolicy_ = tailPolicy.NOWAIT;