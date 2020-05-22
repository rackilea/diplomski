context.evaluateScript("a = 10");
JSValue newAValue = context.property("a");
System.out.println(df.format(newAValue.toNumber())); // 10.0
String script =
    "function factorial(x) { var f = 1; for(; x > 1; x--) f *= x; return f; }\n" +
    "var fact_a = factorial(a);\n";
context.evaluateScript(script);
JSValue fact_a = context.property("fact_a");
System.out.println(df.format(fact_a.toNumber())); // 3628800.0