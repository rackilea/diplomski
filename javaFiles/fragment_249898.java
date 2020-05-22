public class ConversationUser extends ThreadLocal<ConversationUser>{

@Override
    protected ConversationUser initialValue() {
        return new ConversationUser();
    }

    }