public class FinalInvocation implements Invocation {
    @Override
    public Object invoke(Object callee, Method method, Object[] args, InvocationChain chain) {
        try {
            return method.invoke(callee, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}