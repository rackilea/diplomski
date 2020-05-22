...
public interface UserDetailOrBuilder
        extends com.google.protobuf.MessageOrBuilder {

    // required string id = 1;
    boolean hasId();

    String getId();

    // optional string nick = 2;
    boolean hasNick();

    String getNick();

    // repeated double money = 3;
    java.util.List<java.lang.Double> getMoneyList();

}

public static final class UserDetail extends
        com.google.protobuf.GeneratedMessage
        implements UserDetailOrBuilder ...