// "workspace" is a string that contains the path to the workspace containing the DSL program.
new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri(workspace);

Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

// "DSLProgram" is a string that contains the path to the file of the DSL program relative to the workspace set above.
Resource resource = resourceSet.getResource(URI.createURI("platform:/resource/" + DSLProgram), true);
Model model = (Model) resource.getContents().get(0);