// using normal class loader 
     Class<?> clazz = Class.forName("com.abc.bla.bla.SandBox", true, Thread.currentThread().getContextClassLoader());
     Constructor<?> constructor = clazz.getConstructor();
     Object obj = constructor.newInstance(new Object[] {});

     Method method = clazz.getMethod("sayHello", new Class[] {});
     method.invoke(obj, new Object[] {});
  }
  catch (Exception ex)
  {
     ex.printStackTrace();
  }