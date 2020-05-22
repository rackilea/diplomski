static void callMethod(Object receiver,
      String methodName, Object... params) {
  if (receiver == null || methodName == null) {
    return;
  }
  Class<?> cls = receiver.getClass();
  Method[] methods = cls.getMethods();
  Method toInvoke = null;
  methodLoop: for (Method method : methods) {
    if (!methodName.equals(method.getName())) {
      continue;
    }
    Class<?>[] paramTypes = method.getParameterTypes();
    if (params == null && paramTypes == null) {
      toInvoke = method;
      break;
    } else if (params == null || paramTypes == null
        || paramTypes.length != params.length) {
      continue;
    }

    for (int i = 0; i < params.length; ++i) {
      if (!paramTypes[i].isAssignableFrom(params[i].getClass())) {
        continue methodLoop;
      }
    }
    toInvoke = method;
  }
  if (toInvoke != null) {
    try {
      toInvoke.invoke(receiver, params);
    } catch (Exception t) {
      t.printStackTrace();
    }
  }
}