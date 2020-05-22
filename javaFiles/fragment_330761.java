@EJB private EntityBeanHomeA entityBeanHomeA;    

@EJB private EntityBeanHomeB entityBeanHomeB;    

@EJB private EntityBeanHomeC entityBeanHomeC;    

@EJB private SessionBeanD sessionBeanD;    

@Resource
private MessageDrivenContext mdc;

public void onMessage(Message msg) {

    final String beanName = // extract somehow the bean's name from 'msg'
    final Object obj = getDependentEJB(beanName);
    // do something with 'obj'
}

private Object getDependentEJB(String beanName) {
    Object result = null;
    if ("EntityBeanHomeA".equals(beanName)) {
         result = entityBeanHomeA;
    else if ("EntityBeanHomeB".equals(beanName)) {
         result = entityBeanHomeB;
    else ("EntityBeanHomeC".equals(beanName)) {
         result = entityBeanHomeC;
    else ("SessionBeanD".equals(beanName)) {
         result = sessionBeanD;
    }
    return result;
}