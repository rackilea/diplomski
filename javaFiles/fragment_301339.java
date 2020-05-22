J:\WS\Java test>javac Main.java -Xdiags:verbose
Main.java:11: error: method replaceAll in interface List<E> cannot be applied to given types;
        attributes.replaceAll((in) -> {
                             ^
  required: UnaryOperator<CAP#1>
  found: (in)->{ Li[...]ut; }
  reason: argument mismatch; bad return type in lambda expression
      List<String> cannot be converted to CAP#1
  where E is a type-variable:
    E extends Object declared in interface List
  where CAP#1 is a fresh type-variable:
    CAP#1 extends Collection<String> from capture of ? extends Collection<String>
1 error