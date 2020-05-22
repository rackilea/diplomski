CompilationUnitContext compilationUnit;
try {
  // Stage 1: High-speed parsing for correct documents

  parser.setErrorHandler(new BailErrorStrategy());
  parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
  parser.getInterpreter().tail_call_preserves_sll = false;
  compilationUnit = parser.compilationUnit();
} catch (ParseCancellationException e) {
  // Stage 2: High-accuracy fallback parsing for complex and/or erroneous documents

  // TODO: reset your input stream
  parser.setErrorHandler(new DefaultErrorStrategy());
  parser.getInterpreter().setPredictionMode(PredictionMode.LL);
  parser.getInterpreter().tail_call_preserves_sll = false;
  parser.getInterpreter().enable_global_context_dfa = true;
  compilationUnit = parser.compilationUnit();
}