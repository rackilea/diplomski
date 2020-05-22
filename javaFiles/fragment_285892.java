public void  setIdOnObject(Object obj, Object id)
    {
        try{
         Method m =  obj.getClass().getMethod("setId",id.getClass());
            m.invoke(obj, id );

        }catch(NoSuchMethodException  e){ return false; } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }