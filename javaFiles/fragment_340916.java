package foo.bar;

import javax.annotation.processing.Processor;

@AutoService(Processor.class) 
final class MyProcessor extends Processor {
  // … 
}