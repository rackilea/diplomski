public class XmppChatManager{
   static class Loader{
        static XmppChatManager sInstance = new XmppChatManaget();
   }

   public static XmppChatManager getInstance(){
        return Loader.sInstance;
   }
}