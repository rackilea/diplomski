BeanManager beanManager; // assuming you have obtained BM somehow
CreationalContext<Object> ctx = beanManager.createCreationalContext(null);
InjectionTarget<MyPOJO> injectionTarget = beanManager
                    .getInjectionTargetFactory(beanManager.createAnnotatedType(MyPOJO.class)).createInjectionTarget(null);
injectionTarget.inject(myPojoInstance, ctx);
creationalContext = ctx; // store ctx so you can later on use it to dispose of the dependent instance!