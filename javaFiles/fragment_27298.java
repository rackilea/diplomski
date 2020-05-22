/**
 * @author Kumar Sambhav Jain
 * 
 */
public aspect SetterMonitoringAspect {

/**
 * All classes annotated with @Monitored will implement the MonitoredBean
 * interface.
 */
declare parents : (@com.samsoft.bean.monitor.annotation.Monitored *) implements com.samsoft.bean.monitor.MonitoredBean;

/*
 * ******************************************** INTER TYPE DECLARATION START
 */

/**
 * Injected PropertyChangeSupport
 * 
 * @return
 */
private Map<String, Object> MonitoredBean.cache = null;

/**
 * 
 * @return true if start monitored was invoked on the bean.
 */
public boolean MonitoredBean.isMonitorinActive() {
    return cache != null;
}

/**
 * Stop Monitoring the bean.
 */
public void MonitoredBean.stopMonitoring() {
    cache = null;
}

/**
 * Start monitoring the bean for changes. Also Resets the
 * PropertyChangeSupport property.
 * 
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 */
public void MonitoredBean.startMonitor() {
    cache = new HashMap<String, Object>();
}

/**
 * 
 * @return null if monitoring is not enabled. true if the bean
 *         property/properties changed after startMonitor() was invoked on
 *         it.
 */
public Boolean MonitoredBean.hasChanged() {
    if (cache == null) {
        return null;
    } else {
        return cache.size() > 0;
    }
}

/**
 * Check if a particular property has changed.
 * 
 * @param propertyName
 *            Exact case sensitive property name.
 * @return null if the property was not changed. Old value if the property
 *         was changed.
 */
public Object MonitoredBean.hasChanged(String propertyName) {
    return cache.get(propertyName);
}

/*
 * ********************************************* INTER TYPE DECLARATION END
 */

/**
 * Point cut for setter methods of Java bean implementing.
 * 
 * {@link MonitoredBean}
 */
pointcut monitoredBeanInterfaceSetters(
        com.samsoft.bean.monitor.MonitoredBean monitoredBean) : target(monitoredBean) && within(@com.samsoft.bean.monitor.annotation.Monitored *) && execution(public void set*(..));

/**
 * Before advice on a setter of a monitored bean.
 * 
 * @param monitoredBean
 * @param joinPoint
 */
@Before(argNames = "monitoredBean", value = "monitoredBeanInterfaceSetters(monitoredBean)")
public void beforeSetterAdvice(MonitoredBean monitoredBean,
        JoinPoint joinPoint) {
    if (monitoredBean.isMonitorinActive()) {
        try {
            String fieldName = joinPoint.getStaticPart().getSignature()
                    .getName().substring(3).toLowerCase();
            Object newValue = joinPoint.getArgs()[0];

            Field declaredField = monitoredBean.getClass()
                    .getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            Object oldValue = declaredField.get(monitoredBean);

            if (oldValue == null && newValue == null) {
                return;
            } else if ((oldValue == null && newValue != null)
                    || (oldValue != null && newValue == null))  {
                monitoredBean.cache.put(fieldName, oldValue);
            } else if (oldValue != null && newValue != null) {
                if (!oldValue.equals(newValue)) {
                    monitoredBean.cache.put(fieldName, oldValue);
                } else {
                    monitoredBean.cache.remove(fieldName);
                }
            }
        } catch (Exception e) {
            monitoredBean.cache = null;
            e.printStackTrace();
        }
    }
}
}