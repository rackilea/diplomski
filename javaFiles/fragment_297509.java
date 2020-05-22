package com.sandbox;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SandboxTest {

    @Test
    public void testMocking() {
        Foo foo = mock(Foo.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                String name = invocation.getMethod().getName();
                if (name.contains("get")) {
                    return "this is a getter";
                }
                return null;
            }
        });

        assertEquals("this is a getter", foo.getY());
        assertEquals("this is a getter", foo.getX());
    }

    public static class Foo {
        private String x;
        private String y;

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        public String getY() {
            return y;
        }

        public void setY(String y) {
            this.y = y;
        }
    }

}