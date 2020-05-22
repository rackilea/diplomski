System.out.println(new GroovyShell().evaluate(
          "def builder = new groovy.json.JsonBuilder();"
        + "def age = 23;"
        + "builder.example {"
        + "  name 'Fred';"
        + "  delegate.age 27;"
        + "  blah {"
        + "    foo 'bar';"
        + "  };"
        + "};"
        + "return builder.toPrettyString()"));