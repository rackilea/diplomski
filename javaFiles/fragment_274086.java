public class Bean {

    public interface Delegate {
        void doSomething();
    }

    public class MethodADelegate implements Delegate {
        public void doSomething() {

        }
    }

    public class MethodBDelegate implements Delegate {
        public void doSomething() {

        }
    }

    private Delegate delegate;

    public String methodA() {
        this.delegate = new MethodADelegate();
        return "view2";
    }

    public String methodB() {
        this.delegate = new MethodBDelegate();
        return "view2";
    }

    public String view2Call() {
        delegate.doSomething();
        return "done";
    }
}

<h:commandLink action="#{bean.methodA}" value="Second view with method A" />
<h:commandLink action="#{bean.methodB}" value="Second view with method B" />

<h:commandButton action="#{bean.view2Call}" value="Call the method" />