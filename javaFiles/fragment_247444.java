package org.gr8ex

class HelloTest extends GroovyTestCase {
    void 'test Hello should return "Hello, World!"' () {
        assert new Hello().world == "Hello, World!"
    }
}