public void configure(Binder binder) {

    if(widgetInterceptionEnabled){
        binder.bindInterceptor(Matchers.any(), Matchers.any(),
            new WidgetInterceptor());
    }

}