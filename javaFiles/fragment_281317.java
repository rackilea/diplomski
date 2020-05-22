@Override
protected void init()
{
    // initialize Spring
    addComponentInstantiationListener(new SpringComponentInjector(this, applicationContext));
}