public class GCMIntentService extends GCMBaseIntentService{
private static ArrayList<Message> messageQueue = new ArrayList<Message>();
private static boolean isProcessingMessage = false;

onMessage(Context context, Intent intent)
{
 if(isProcessingMessage)
   {
    Message currentMsg = new Message();//Create a instance of message and put it in arrayList

   }
   else{
         isProcessingMessage = true;
          for(int i  = 0; i < messageQueue.size(); i++)
             {//  Process all your messages in the queue here
               messageQueue.remove(i);
              }
              isProcessingMessage = false;
       }
}

 private class Message{

//In this class you can configure your message that you are going to queue.
}
}