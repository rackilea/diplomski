public class JavaRunner {

public static void compile(String name, String code){
  compile(name,code,5000);
}
/**
 * compiles and runs main method from code
 * @param name      Class Name
 * @param code      String to compile
 * @param timeLimit (otional) limit for code to run, default to 5 seconds
 */
public static void compile(String name, String code, int timeLimit){

    /*Creating dynamic java source code file object*/
    SimpleJavaFileObject fileObject = new DynamicJavaSourceCodeObject (name, code) ;
    JavaFileObject javaFileObjects[] = new JavaFileObject[]{fileObject} ;

    /*Instantiating the java compiler*/
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    /**
     * Retrieving the standard file manager from compiler object, which is used to provide
     * basic building block for customizing how a compiler reads and writes to files.
     *
     * The same file manager can be reopened for another compiler task.
     * Thus we reduce the overhead of scanning through file system and jar files each time
     */
    StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, null, null);
    //uses custom file manager with defined class loader inorder to unload the compiled class when this is done
    ClassFileManager fileManager =  new ClassFileManager(stdFileManager);

    /* Prepare a list of compilation units (java source code file objects) to input to compilation task*/
    Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(javaFileObjects);

    /*Prepare any compilation options to be used during compilation*/
    //In this example, we are asking the compiler to place the output files under bin folder.
    List<String> compileOptions = new ArrayList<String>();
    // compileOptions.addAll(Arrays.asList("-classpath", System.getProperty("java.class.path")));
    // Iterable<String> compilationOptionss = Arrays.asList(compileOptions);

    /*Create a diagnostic controller, which holds the compilation problems*/
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

    /*Create a compilation task from compiler by passing in the required input objects prepared above*/
    CompilationTask compilerTask = compiler.getTask(null, fileManager, diagnostics, compileOptions, null, compilationUnits) ;

    //Perform the compilation by calling the call method on compilerTask object.
    boolean status = compilerTask.call();

    if (!status){//If compilation error occurs
        /*Iterate through each compilation problem and print it*/
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()){
            System.err.format("Error on line %d in %s", diagnostic.getLineNumber(), diagnostic);
        }
    } else {
      ExecutorService service = Executors.newSingleThreadExecutor();

      try {
          Runnable r = new Runnable() {
              @Override
              public void run() {
                try {
                  fileManager.getClassLoader(null).loadClass(name).getDeclaredMethod("main", new Class[] { String[].class }).invoke(null, new Object[] { null });
                } catch (ClassNotFoundException e) {
                  System.err.println("Class not found: " + e);
                } catch (NoSuchMethodException e) {
                  System.err.println("No such method: " + e);
                } catch (IllegalAccessException e) {
                  System.err.println("Illegal access: " + e);
                } catch (InvocationTargetException e) {
                  System.err.println("RuntimeError: "+e.getTargetException());
                }
                try {
                    fileObject.delete();
                    fileManager.close();
                    ResourceBundle.clearCache(ClassLoader.getSystemClassLoader()); // <--useless
                } catch (IOException e) {
                    e.printStackTrace();
                }
              }
          };

          Future<?> f = service.submit(r);

          f.get(timeLimit, TimeUnit.MILLISECONDS);
      }
      catch (final InterruptedException e) {
        System.err.println("Thread Interrupted: " + e);
      }
      catch (final TimeoutException e) {
        System.err.println("TimeoutException: Your program ran for more than "+timeLimit);
      }
      catch (final ExecutionException e) {
        e.printStackTrace();
      }
      finally {
          service.shutdown();
      }
    }        
}
}