public class HandlerEnabledTester extends PropertyTester {

private static final String PROPERTY_HANDLER_ENABLED = "handlerEnabled";

@Override
public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
    if (PROPERTY_HANDLER_ENABLED.equals(property)) {
        return isHandlerEnabled((String) expectedValue);
    }
    return false;
}

private static boolean isHandlerEnabled(String commandId) {
    ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
    Command command = commandService.getCommand(commandId);
    return command.isEnabled();
}
}