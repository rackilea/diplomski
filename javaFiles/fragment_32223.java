Scriptable scope = context.newObject(global);
scope.setPrototype(global);
scope.setParentScope(null);

NativeJavaTopPackage $packages = (NativeJavaTopPackage) global.get("Packages");
NativeJavaPackage $java = (NativeJavaPackage) $packages.get("java");
NativeJavaPackage $java_io = (NativeJavaPackage) $java.get("io");

ProxyNativeJavaPackage proxy$java = new ProxyNativeJavaPackage($java);
ProxyNativeJavaPackage proxy$java_io = new ProxyNativeJavaPackage($java_io);
proxy$java_io.put("File", scope, get(scope, "Packages." + PseudoFile.class.getName()));
proxy$java_io.put("FileInputStream", scope,
        get(scope, "Packages." + PseudoFileInputStream.class.getName()));
proxy$java_io.put("FileOutputStream", scope,
        get(scope, "Packages." + PseudoFileOutputStream.class.getName()));
proxy$java.put("io", scope, proxy$java_io);
scope.put("java", scope, proxy$java);