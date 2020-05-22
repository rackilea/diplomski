private static Filer filer;
private static JavacProcessingEnvironment environment;
private static Messager messager;
private static Types types;
private static JavacElements elementUtils;
private Trees trees;
private TreeMaker treeMaker;
private IdentityHashMap<JCCompilationUnit, Void> compilationUnits;
private Map<String, JCCompilationUnit> typeMap;