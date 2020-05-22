interface ResultProcessor {
    processTypeA(A item);
    processTypeB(B item);
    processTypeC(C item);
}

interface InputProcessor {
    processInput(ResultProcessor target);
}

class ConcreteInputProcessorA {
    processInput(ResultProcessor target) {
      A result = ...; // Do something
      target.processTypeA(result);
    }
}

class ConcreteInputProcessorB {
    processInput(ResultProcessor target) {
      B result = ...; // Do something
      target.processTypeB(result);
    }
}

class ConcreteInputProcessorC {
    processInput(ResultProcessor target) {
      C result = ...; // Do something
      target.processTypeC(result);
    }
}