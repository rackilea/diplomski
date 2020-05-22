PivotHierarchyTopElement top = ...; // whatever you need to do to make that
Injector firstStageInjector = Guice.createInjector(
   // here put all the modules needed to define bindings for stuff injected into the
   // pivot hierarchy.  However, don't put anything for stuff that needs pivot
   // created things injected into it.
);
InjectionVisitorImpl visitor = new InjectionVisitorImpl(firstStageInjector);
top.acceptInjectionVisitor(visitor);
Injector fullInjector = visitor.createFullInjector(
  // here put all your other modules, including stuff that needs pivot-created things
  // injected into it.
);
RealMainClass realMain = fullInjector.getInstance(RealMainClass.class);
realMain.doWhatever();