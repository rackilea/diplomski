package com.sample.jetty;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.ErrorHandler;

public class MyErrorHandler extends ErrorHandler {

    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getOutputStream().println("error!");
    }

    public void handleErrorPage(HttpServletRequest request, Writer writer, int code, String message)
            throws IOException {
        writer.write("error!");
    }

    public void writeErrorPage(HttpServletRequest request, Writer writer, int code, String message, boolean showStacks)
            throws IOException {
        writer.write("error!");
    }

    public void writeErrorPageHead(HttpServletRequest request, Writer writer, int code, String message)
            throws IOException {
        writer.write("error!");
    }

    public void writeErrorPageBody(HttpServletRequest request, Writer writer, int code, String message,
            boolean showStacks) throws IOException {
        writer.write("error!");
    }

    public void writeErrorPageMessage(HttpServletRequest request, Writer writer, int code, String message, String uri)
            throws IOException {
        writer.write("error!");
    }

    public void writeErrorPageStacks(HttpServletRequest request, Writer writer) throws IOException {
        writer.write("error!");
    }

}