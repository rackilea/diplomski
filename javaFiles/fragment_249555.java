private static final String BEAN_NAME = "CacheBean";

//access to the bean
    public static CacheBean get() {
            return (CacheBean) JSFUtil.resolveVariable(BEAN_NAME);
    }

//in my JSFUtil class I have the method
public static Object resolveVariable(String variable) {
        return FacesContext.getCurrentInstance().getApplication().getVariableResolver().resolveVariable(FacesContext.getCurrentInstance(), variable);
    }