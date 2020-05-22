//bean atribute
private SessionContext context;

//bean method call by the Container
public void setSessionContext(SessionContet ctx) {
context = ctx;
}

//your first delete code
try {
      ...
      EJBLocalObject local_another_o = getEjbLocalObject(local_o.getAnotherId());
      local_another_o.remove();
      ...
} catch (Exception e) {
   context.setRollbackOnly();
   //log exception
   //throw new Exception
}
//idem for your second delete