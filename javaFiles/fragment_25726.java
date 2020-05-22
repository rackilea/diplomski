package com.example

public class CustomDialect extends PostgreSQL95Dialect {
    public CustomDialect () {
        this.registerColumnType(Types.BLOB, "lo");
    }
}