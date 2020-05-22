public class ExportClassDigestApplication implements IApplication {

    public Object start(IApplicationContext context) throws Exception {
        context.applicationRunning();

        List<ExtensionBean> extensionBeans = ImpCoreUtil.loadExtensionBeans(&quot;com.xab.core.containerlaunchers&quot;);
        for (ExtensionBean bean : extensionBeans) {
            ILauncher launcher = (ILauncher) bean.getInstance();
            launcher.start();
        }
        ClassFilter classFilter = new ClassFilter() {
            public boolean isClassAccepted(Class clz) {
                return true;
            }
        };

        PrintWriter writer = new PrintWriter( new File( "C:/classes.csv"));

        Bundle[] bundles = InternalPlatform.getDefault().getBundleContext().getBundles();