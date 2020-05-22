package com.example

public class CustomDialectResolver extends BasicDialectResolver {
    public CustomDialectResolver() {
        super("PostgreSQL", CustomDialect.class);
    }
}