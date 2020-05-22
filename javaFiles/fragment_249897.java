public class ConversationUser extends ThreadLocal<ConversationUser>{
    private static ThreadLocal<ConversationUser> current= null;

@Override
    protected ConversationUser initialValue() {
        return new ConversationUser();
    }

    public static ConversationUser getCurrent() {
        if (current == null) {
            current = new ConversationUser();
        }
        return current.get();
    }

    }