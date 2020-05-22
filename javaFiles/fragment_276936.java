public class ConversationHolder extends ThreadLocal<UUID>{

    private static ConversationHolder INSTANCE = new ConversationHolder();

    public static void setId(UUID conversationId){
          INSTANCE.set(conversationId);
    }

    public static UUID getId(){
        return INSTANCE.get();
    }

    public static void clear(){
        INSTANCE.remove();
    }

}