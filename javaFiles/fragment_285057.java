Processor<String> proc = ...
proc.addHandler(new Handler<String>());   // valid
proc.addHandler(new Handler<Object>());   // valid, as Strings are Objects too
proc.addHandler(new Handler<Integer>());  // invalid, not a String handler
proc.process("good");     // valid
proc.process(1);          // invalid, not a String