package com.example;

import java.io.StringWriter;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

public class Nashorn {
    public static void main(String[] args) throws ScriptException {
        String[] arguments = new String[] {"-strict", "--no-java", "--no-syntax-extensions", "-dump-on-error"};
        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine(arguments);
        StringWriter sw = new StringWriter();
        ScriptContext context = engine.getContext();
        context.setWriter(sw);
        context.setErrorWriter(sw);
        engine.eval("print('hello world')");
        System.out.println("redirected output: " + sw);
    }
}