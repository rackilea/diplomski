// Obtain the handles
long hCryptKey = (Long)MethodUtils.invokeMethod(mscapiPrivKey, "getHCryptKey");
long hCryptProvider = (Long)MethodUtils.invokeMethod(mscapiPrivKey, "getHCryptProvider");
// Call the internal native method
Class<?> internalClass = Class.forName("sun.security.mscapi.RSASignature");
Method internalSignHashMethod = internalClass.getDeclaredMethod("signHash", boolean.class, byte[].class, int.class, String.class, long.class, long.class);
internalSignHashMethod.setAccessible(true);
byte[] res = (byte[])internalSignHashMethod.invoke(internalClass, false, btHash, btHash.length, "SHA-256", hCryptProvider, hCryptKey);
ArrayUtils.reverse(res); // Make it big endian