public class ClassToTest {

    MethodStore methodStore;
    MethodInvoker methodInvoker;
    ClassToInvoke classToInvoke;
    ObjectRunner objectRunner;  

    public void testMethod(InterfaceA obj) throws Exception {

        Method method = methodStore.getMethod(obj);

        boolean ok = false;

        if (method != null) {
            ok = methodInvoker.invoke(method, classToInvoke, obj);
        }

        if (ok) {
            objectRunner.run(obj);
        }   
    }

    public void setMethodStore(MethodStore methodStore) {
        this.methodStore = methodStore;
    }

    public void setMethodInvoker(MethodInvoker methodInvoker) {
        this.methodInvoker = methodInvoker;
    }

    public void setObjectRunner(ObjectRunner objectRunner) {
        this.objectRunner = objectRunner;
    }

    public void setClassToInvoke(ClassToInvoke classToInvoke) {
        this.classToInvoke = classToInvoke;
    }
}