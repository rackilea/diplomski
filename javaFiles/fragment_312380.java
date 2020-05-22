package com.test.service;

import java.util.*;
import javax.persistence.*;
import javax.ws.rs.*;

@Path("/service")
public class TestService {

    @PersistenceUnit(unitName = "test")
    private EntityManagerFactory entityManagerFactory;

    @GET
    @Path("/get")
    @Produces("application/json")
    public List get() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("from TestEntity").getResultList();
        } finally {
            entityManager.close();
        }
    }
}