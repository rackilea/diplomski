if (p.isJumpPatched() && !voidReturn) {
  if (isJavaDialect) {
    // TODO :: I don't think we need to throw an Error/Exception to mark that a return statement is missing as the compiler will flag this error automatically
    if (Options.isLegacyExceptionHandling()) {
        codeGenerator.genCodeLine("    throw new "+(Options.isLegacyExceptionHandling() ? "Error" : "RuntimeException")+"(\"Missing return statement in function\");");
    }
  } else {
    codeGenerator.genCodeLine("    throw \"Missing return statement in function\";");
  }
}