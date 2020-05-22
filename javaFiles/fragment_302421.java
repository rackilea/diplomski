package de.scrum_master.app;

import java.util.Map;

public class Application {
    public void notAnnotated(String s, Map<String, Object> m) {}

    @MyCustomAnnotation
    public void correctSignature(String s, Map<String, Object> m) {}

    @MyCustomAnnotation
    public void wrongSignature(String s, Map<String, String> m) {}
}