public void callService() {
    ServiceReference<MyInterface> reference
     = bundleContext.getServiceReference(MyInterface.class);
    MyInterface foo = bundleContext.getService(reference);
    try {
        //use service
        String msg = service.shout();
    } finally {
        bundleContext.ungetService( reference );
    }
}