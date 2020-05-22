// Normally the appName is the EAR name
// Leave it empty if your application isn't packaged in a EAR
String appName = "your_application_name/";
// The EJB module name
String moduleName = "ejb_module_name/";
String beanName = NewSessionBean.class.getSimpleName();
String viewClassName = NewSessionBeanRemote.class.getName();

(NewSessionBeanRemote) context.lookup(appName + moduleName + beanName + "!" + viewClassName);