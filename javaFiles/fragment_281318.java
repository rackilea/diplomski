@Override
protected void init()
{
    // initialize Spring
    getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext))
}