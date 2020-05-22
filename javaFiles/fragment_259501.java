//This is in Persist Layer
public void save(Student student) throws AppException{
        //converting general exception to AppException and delegating to Facade Layer

        try{
            em.persist(student);//call to DB. This is in Persist Layer
        }catch(Exception e){
            throw new AppException("DB exception", e)
        }
    }