package com.example.rest;

import static com.jayway.restassured.RestAssured.expect;
import groovyx.net.http.ContentType;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class Products{

    @Before
    public void setUp(){
        RestAssured.basePath = "http://localhost:8080";
    }

    @Test
    public void testGetProducts(){
        expect().statusCode(200).contentType(ContentType.JSON).when()
                .get("/getProducts/companyid/companyname/12345088723");
    }

}