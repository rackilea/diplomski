package com.firsttest.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firsttest.pojo.SampleRequest;

@RestController
@RequestMapping("/test")
public class FirstTestController {



    @PostMapping("/getBySignatureOne")
    public ResponseEntity<?> getTestString(@Valid @RequestBody SampleRequest sampleRequest) {
        System.out.println("getFromDate : " + sampleRequest.getFromDate());
        System.out.println("getToDate : " + sampleRequest.getToDate());
        return null;//I dont want to send any response.
    }
}