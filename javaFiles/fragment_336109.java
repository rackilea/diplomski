public class SpringHttpContextLoaderListener extends ContextLoaderListener {

    private ContextLoader loader;

    protected ContextLoader createContextLoader() {
        loader = new SpringHttpContextLoader();
        return loader;
    }

    public ContextLoader getContextLoader(){
        return loader;
    }

}