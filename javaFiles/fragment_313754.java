module org.foo {
    requires transitive java.logging;

    exports org.foo.logging;

    exports org.foo.logging.internal to
        java.logging;
}