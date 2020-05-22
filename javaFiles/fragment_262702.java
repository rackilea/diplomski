public enum QueueItemType {
      CONSUMABLE,
      SHUTDOWN
   }

   public class QueueItem {
      public final QueueItemType type;
      public final String payload;

      public QueueItem(QueueItemType type, String payload) {
         this.type = type;
         this.payload = payload;
      }
   }

   public class B implements Runnable {
      private Parent parent;

      public B(Parent p) {
         parent = p;
      }

      public void run() {
         while(true) {
            QueueItem data = parent.getData().poll();
            if (data.type == QueueItemType.SHUTDOWN) {
               break;
            } else {
               // do more stuff with data.payload
            }
         }
      }
   }