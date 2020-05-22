Method method = null;
Class<?> type = null;
Class<?> propertyEditorClass = null;
try {
    java.beans.BeanInfo info
        = java.beans.Introspector.getBeanInfo(bean.getClass());
    if ( info != null ) {
        java.beans.PropertyDescriptor pd[]
            = info.getPropertyDescriptors();
        for (int i = 0 ; i < pd.length ; i++) {
            if ( pd[i].getName().equals(prop) ) {
                method = pd[i].getWriteMethod();
                type   = pd[i].getPropertyType();
                propertyEditorClass = pd[i].getPropertyEditorClass();
                break;
            }
        }
    }
    if ( method != null ) {
        if (type.isArray()) {
            if (request == null) {
                throw new JasperException(
                    Localizer.getMessage("jsp.error.beans.setproperty.noindexset"));
            }
            Class<?> t = type.getComponentType();
            String[] values = request.getParameterValues(param);
            //XXX Please check.
            if(values == null) return;
            if(t.equals(String.class)) {
                method.invoke(bean, new Object[] { values });
            } else {
                createTypedArray (prop, bean, method, values, t,
                                  propertyEditorClass); 
            }
        } else {
            if(value == null || (param != null && value.equals(""))) return;
            Object oval = convert(prop, value, type, propertyEditorClass);
            if ( oval != null )
                method.invoke(bean, new Object[] { oval });
        }
    }
} catch (Exception ex) {
    Throwable thr = ExceptionUtils.unwrapInvocationTargetException(ex);
    ExceptionUtils.handleThrowable(thr);
    throw new JasperException(ex);
}