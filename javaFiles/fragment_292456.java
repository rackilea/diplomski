public class MethodLoggingInterceptor implements MethodInterceptor{

    private InitBean initBean;

    public Object invoke(MethodInvocation method) throws Throwable {
        if (!"toString".equals(method.getMethod().getName())) {
            StringBuilder sb = new StringBuilder();
            Object obj = method.getThis();
            if (obj instanceof GoBean) {
                Map<String,String> beanMap = initBean.getBeanMap();
                String objToString = obj.toString();
                if (beanMap.containsKey(objToString)) {
                    System.out.println(beanMap.get(objToString));
                    sb.append("bean: ");
                    sb.append(beanMap.get(objToString));
                    sb.append(" : ");
                }
            }
            sb.append(method.getMethod().getDeclaringClass());
            sb.append('.');
            sb.append(method.getMethod().getName());
            System.out.println(sb.toString() + " starts");
            Object result = method.proceed();
            System.out.println(sb.toString() + " finished");
            return result;
        } else {
            return method.proceed();
        }

    }

    public void setInitBean(InitBean ib) {
        this.initBean = ib;
    }        
}