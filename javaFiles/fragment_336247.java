ScriptEngine engine = new ScriptEngineManager()
                           .getEngineByExtension("js");

JSObject rick = (JSObject) engine.eval("new function () {\n" +
        "            this.name = \"Rick\";\n" +
        "            this.age = 28;\n" +
        "            this.speak = function () {\n" +
        "                return this.name + \"-\" + this.age;\n" +
        "            }\n" +
        "        };");

System.out.println(rick.getMember("name"));