List<String> result1 = result; // compiler error: type mismatch (not assignable)
List<Object> result2 = result; // compiler error: type mismatch (not assignable)

List result3 = result; // ok
List<?> result4 = result; // ok

List<? super String> result5 = result; // ok
List<? extends Object> result6 = result; // ok