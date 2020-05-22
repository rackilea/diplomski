public class InjectionHelper {

    private static final String DEPENDENCY_SEPERATOR = "/";

    private static Logger logger = Logger.getLogger(InjectionHelper.class);

    private static Map<Class<?>, Object> dependencies = null;

    private static List<Object> dependenciesList = null;

    private static Context baseContext = null;

    /**
     * Search for the dependency of the specified class.
     */
    public static final <T> T injectDependency(Class<T> dependencyClass){

        //initialise the dependencies
        if(dependenciesList == null){
            dependenciesList = new ArrayList<Object>();
            dependencies = new HashMap<Class<?>, Object>();
            try{
                baseContext = new InitialContext();
                populateDependencies(baseContext, new Stack<String>());
            }
            catch(Exception e){
                logger.error("Error populating dependencies", e);
            }
        }

        //We have seen this dependency before and can get it from the map
        if(dependencies.containsKey(dependencyClass)){
            return (T)dependencies.get(dependencyClass);
        }

        //Not seen the dependency so we must try and find it in the list 
        for(Object o: dependenciesList){
            if(dependencyClass.isInstance(o)){
                dependencies.put(dependencyClass, o);
                return (T)o;
            }
        }

        //We don't have the dependency
        return null;
    }

    /**
     * Traverse the InitialContext and extract all dependencies and store them in the map keyed by their class.
     *  
     * @param lookupNameStack
     */
    private static final void populateDependencies(Context ctx, Stack<String> lookupNameStack) {
        try {
            NamingEnumeration<Binding> list = ctx.listBindings("");

            while (list.hasMore()) {
               Binding item = list.next();

               //Get the name and object for the binding
               String lookupName = item.getName();
               Object objectBinding = item.getObject();

               //If a JavaGlobalJndiNamingObjectProxy this is a dependency we want to store
               if(objectBinding instanceof JavaGlobalJndiNamingObjectProxy){

                   //Based on our current position in the tree get the string representation
                   Iterator<String> lookupNameIterator = lookupNameStack.iterator();
                   String lookupPrefix = "";
                   while(lookupNameIterator.hasNext()){
                       lookupPrefix += lookupNameIterator.next();
                   }

                   //lookup the object and store in the map
                   try{
                       Object obj = baseContext.lookup(lookupPrefix+lookupName);
                       dependenciesList.add(obj);
                       logger.info("Found [" + obj.getClass() + "] Lookup [" + lookupPrefix + lookupName +"]");
                   }
                   catch(Exception e){
                       logger.info("Failed to find Lookup [" + lookupPrefix+lookupName + "]", e);
                   }
               }
               lookupNameStack.push(lookupName+DEPENDENCY_SEPERATOR);

               //If we find a context we can explore that branch
               if (objectBinding instanceof Context) {
                   populateDependencies((Context) objectBinding, lookupNameStack);
               }
               //Now we have traversed the branch we need to remove the last leaf
               lookupNameStack.pop();
           }

        } catch (NamingException ex) {
           logger.info("JNDI failure: ", ex);
        }
    }
}