package com.springJPA.util;


public class TransactionAspect {


    private MyEntityManagerFactory entityManagerFactory;

    public void begin(){
        entityManagerFactory.getEntityManager().getTransaction().begin();
    }

    public void commit(){
        entityManagerFactory.getEntityManager().getTransaction().commit();
    }

    public MyEntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    public void setEntityManagerFactory(MyEntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

}