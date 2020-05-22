package com.emg.server.controller.rest;

import java.io.File;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
@EnableWebMvc
public class StreamRecordsController {

    @RequestMapping(value = "/streamrecords", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<StreamingResponseBody> export() {
         File file = new File("C:\\Users\\Ankur\\sample.pdf");
            StreamingResponseBody responseBody = outputStream -> {
                Files.copy(file.toPath(), outputStream);
            };
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generic_file_name.pdf")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(responseBody);
        }
}