String className  = _model.getClass().getName() + _transactionToken + Helper.getUnixTimestamp() / Math.random();

    ClassPool pool    = ClassPool.getDefault();    
    pool.insertClassPath(new ClassClassPath(_model.getClass())); 

    CtClass copyClass       = pool.getAndRename(_model.getClass().getName(),className);
    CtClass originalClass   = pool.get(_model.getClass().getName());
    ClassFile copyClassFile = copyClass.getClassFile();
    ConstPool constPool     = copyClassFile.getConstPool();

    copyClass.setSuperclass(pool.get(_model.getClass().getName()));
    copyClass.removeMethod(copyClass.getDeclaredMethod(Settings.ENTITY_LOAD_METHODNAME));

    //creates a new method without codeattribute BUT(!) it is abstract
    CtMethod newLoadMethod = new CtMethod(CtClass.voidType, Settings.ENTITY_LOAD_METHODNAME, new CtClass[] {originalClass}, copyClass);
    CtMethod oldLoadMethod = originalClass.getDeclaredMethod(Settings.ENTITY_LOAD_METHODNAME);

    //set modifier to NOT abstract
    newLoadMethod.setModifiers(newLoadMethod.getModifiers() & ~Modifier.ABSTRACT);
    //set the old code attribute
    newLoadMethod.getMethodInfo().setCodeAttribute(oldLoadMethod.getMethodInfo().getCodeAttribute());
    copyClass.addMethod(newLoadMethod);