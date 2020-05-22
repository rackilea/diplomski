List input = new ArrayList(...);

public void doSomething(List input) {
   List inputA = input.subList(0, input.size()/2);
   ...
}

this.doSomething(input);