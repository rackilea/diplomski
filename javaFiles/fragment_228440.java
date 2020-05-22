FacesContext facesContext = FacesContext.getCurrentInstance();
Application app = facesContext.getApplication();
ExpressionFactory elFactory = app.getExpressionFactory();
ELContext elContext = facesContext.getELContext();
ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
return valueExp.getValue(elContext);