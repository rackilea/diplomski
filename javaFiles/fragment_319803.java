public interface Bus<P, B extends Bus<P, B>> {
    <R, Q extends BusRequest<R, P, B>> R execute(Q request);
}

public interface BusRequest<R, P, B extends Bus<P, B>> {
    P getPayload();
}

public static class CommandBus
        implements Bus<CommandBusRequestPayload, CommandBus> {
    @Override
    public <R, Q extends BusRequest<R, CommandBusRequestPayload, CommandBus>>
        R execute(Q request) {
            CommandBusRequestPayload payload = request.getPayload();
            System.out.println("Got payload: " + payload);
            return null;
    }
}

public static abstract class CommandBusRequest<T>
        implements BusRequest<T, CommandBusRequestPayload, CommandBus> {
    @Override
    public CommandBusRequestPayload getPayload() {
        return new CommandBusRequestPayload();
    }
}

public static class CommandBusRequestPayload {}

public static class StringCommandBusRequest
        extends CommandBusRequest<String> {}