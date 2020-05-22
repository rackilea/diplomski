// Add if statement to prevent subsequent code generated
  // from being dead code.
  // NB: eclipse now detects 'if (true)' as dead code, so use the more complicated
  // 'if ("" != null)'
  if (inAction  && (Options.isLegacyExceptionHandling()) ) {
    t.image = "{if (\"\" != null) return";
    jumpPatched = true;
  }