Class clazz = Reflect.compile("com.example.Test",
                "package com.example;" +
                "public class Test {\n" +
                "        public String hello() {\n" +
                "            return \"hello\";\n" +
                "        }\n" +
                "    }")
              .type();