public class MergeListener extends org.hibernate.ejb.event.EJB3MergeEventListener
 {



    @Override
    protected Serializable saveWithGeneratedId(Object entity, String entityName, Object anything, EventSource source, boolean requiresImmediateIdAccess) {


        Integer id = null;


            Field[] declaredFields = entity.getClass().getDeclaredFields();

            for (Field field : declaredFields) {

                Id annotation = field.getAnnotation(javax.persistence.Id.class);

                if(annotation!=null) {


                    try {
                        Method method = entity.getClass().getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
                        Object invoke = method.invoke(entity);

                       id = (Integer)invoke;


                    } catch (Exception ex) {
                      //something failed (method not found..etc) , keep going anyway
                    }

                    break;

                }
            }



       if(id == null ||
                id == 0) {
        return super.saveWithGeneratedId(entity, entityName, anything, source, requiresImmediateIdAccess);
        } else {

            return super.saveWithRequestedId(entity, id, entityName, anything, source);
        }
    }
}