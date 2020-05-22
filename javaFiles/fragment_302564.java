import java.lang.reflect.*;
<%
//getMethod expects method name along with the type of arguments - in this example it's expecting single parameter of type String
Method m = PortletBeanLocatorUtil.locate("another-web-app-portlet").getClass().getMethod("myMethod", String.Class ...)

m.invoke(PortletBeanLocatorUtil.locate("another-web-app-portlet"), new Object[] { new String("blah") });
%>