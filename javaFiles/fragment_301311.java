Class<?>[] params = m.getParameterTypes();
Class<?> r = m.getReturnType();
if(r.getName().equals(Double.class.getName())
   && params.length == 1
   && params[0].getName().equals(String.class.getName()))
{
   // invoke
}