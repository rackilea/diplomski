package com.suman;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
* @author Binod Suman
*/
public class TestApplication {

Logger log = Logger.getLogger(TestApplication.class);
public static void main(String[] args) {
TestApplication test = new TestApplication();
test.saveCompany();
}

public void saveCompany(){
log.info("Company data is going to save");
EntityManagerFactory emf;
Map properties = new HashMap();
properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/sumandb");
properties.put("hibernate.connection.username", "root");
properties.put("hibernate.connection.password", "mysql");
properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
properties.put("hibernate.show-sql", "true");
//emf = Persistence.createEntityManagerFactory("jpablogPUnit");
emf = Persistence.createEntityManagerFactory("jpablogPUnit",properties);
EntityManager entityManager = (EntityManager) emf.createEntityManager();
entityManager.getTransaction().begin();
Company company = new Company(120,"TecnoTree","Espoo, Finland");
entityManager.persist(company);
entityManager.getTransaction().commit();
log.info("Company data has been saved");
}

}