public class MessageTypeOne {

    public int someField;
}

public class MessageTypeTwo {

    public int otherField;
}

public interface MessageFilter<T> {

    boolean doesFilterPass(T message);
}

@Component
@Profile("ProfileOne")
public class OneOfMyMessageFilters<T extends MessageTypeOne> implements MessageFilter<T> {

    public boolean doesFilterPass(MessageTypeOne message) {
        if (message.someField == something) {
            return false;
        } else return true;
    }
}

@Component
@Profile("ProfileTwo")
public class AnotherOneOfMyMessageFilters<T extends MessageTypeTwo> implements MessageFilter<T> {

    public boolean doesFilterPass(MessageTypeTwo message) {
        if (message.otherField == something) {
            return false;
        } else return true;
    }
}

@Service
public class MessageFilterServiceImpl<T> implements MessageFilterService<T> {

    // injected at runtime via Spring profile
    private Set<MessageFilter<T>> messageFilters

    @AutoWired
    public MessageFilterService(Set<MessageFilter<T>> messageFilters) {
        this.messageFilters = messageFilters;
    }

    public boolean passesAllFilters(T message) throws IOException {
        for (MessageFilter filter : messageFilters) {
            if (!filter.doesFilterPass(message)) {
                return false;
            }
        }

        return true;
    }
}

public interface MessageFilterService<T> {

    boolean passesAllFilters(T rawEvent) throws IllegalArgumentException;
}