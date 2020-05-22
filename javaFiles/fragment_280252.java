package com.xxx.yyy.repository;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.testcontainers.containers.OracleContainer;

@TestInstance(Lifecycle.PER_CLASS)
public class MyRepositoryIT {

    @ClassRule
    public OracleContainer oracleContainer;

    @BeforeAll
    public void setup() throws TimeoutException {
        String dockerHost = System.getenv("DOCKER_HOST");
        System.out.println("dockerHost: @" + dockerHost + "@");

        System.out.println("Starting Oracle Container... (" + LocalDateTime.now() + ")");
        oracleContainer = new OracleContainer("wnameless/oracle-xe-11g");
        oracleContainer.start();
        System.out.println("Oracle Container started. (" + LocalDateTime.now() + ")");

    }

    @AfterAll
    public void tearDown() {
        System.out.println("Stopping Oracle Container... (" + LocalDateTime.now() + ")");
        oracleContainer.stop();
        System.out.println("Oracle Container stopped. (" + LocalDateTime.now() + ")");
    }

    @Test
    public void whenSelectQueryExecuted_thenResulstsReturned() throws Exception {

        String jdbcUrl = oracleContainer.getJdbcUrl();
        String username = oracleContainer.getUsername();
        String password = oracleContainer.getPassword();
        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1 FROM DUAL");
        resultSet.next();
        int result = resultSet.getInt(1);

        assertEquals(1, result);

    }

}