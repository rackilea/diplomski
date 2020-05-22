package com.springJPA.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component("myEMF")
public class MyEntityManagerFactory {
    private EntityManager entityManager;
    private String unitName = "SpringJPA";

    public EntityManager getEntityManager() {
        if(entityManager == null){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitName);
        entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

}