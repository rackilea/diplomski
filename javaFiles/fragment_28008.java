public class Terminal {

    public Map<Character, MethodInvoker> commands;

    public Terminal() {
        commands = new HashMap<Character, MethodInvoker>();
    }

    // instance needed, since MethodInvoker#setMethod needs it
    public void addCommand(char letter, Method method, Object instance) {
        MethodInvoker invoker = new MethodInvokerImpl();
        invoker.setMethod(method, instance);
        commands.put(letter, invoker);
    }

    public void executeCommand(char letter, Object... params) throws Exception {
        commands.get(letter).invoke(params);
    }

}