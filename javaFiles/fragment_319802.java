// B is the type of the Bus subclass
public interface Bus<B extends Bus<B>> {
    // R is the response type, and Q is the request type
    <R, Q extends BusRequest<R, B>> R execute(Q request);
}

// a request is parameterized by R, the response type, and B, the bus type
public interface BusRequest<R, B extends Bus<B>> {}

// A CommandBus is a Bus for CommandBusRequests
public static class CommandBus implements Bus<CommandBus> {
    @Override
    public <R, Q extends BusRequest<R, CommandBus>> R execute(Q request) {
        System.out.println("Got request of type: " + request.getClass());
        return null;
    }
}

public interface CommandBusRequest<T> extends BusRequest<T, CommandBus> {}

// StringCommandBusRequest is a BusRequest for a CommandBus that requests
// a response of type String
public static class StringCommandBusRequest
        implements CommandBusRequest<String> {}