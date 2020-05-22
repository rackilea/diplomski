public class InvocationChainImp implements InvocationChain {
    List<Invocation> list = new ArrayList<>();
    Object result;
    Iterator<Invocation> tasks;

    InvocationChainImp() {
        list.add(new LoggingInvocation());
        list.add(new TimerInvocation());
        list.add(new FinalInvocation());
        tasks = list.iterator();
    }

    @Override
    public Object invoke(Object callee, Method method, Object[] args) {
        if (tasks.hasNext()) {
            Object result = tasks.next().invoke(callee, method, args, this);
            this.result = (this.result == null ? result : this.result);
        }
        return this.result;
    }