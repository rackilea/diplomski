private static Map<String, String> getFullCameraParameters (Camera cam) {
    Map<String, String> result = new HashMap<String, String>(64);
    final String TAG = "CameraParametersRetrieval";

    try {
        Class camClass = cam.getClass();

        //Internally, Android goes into native code to retrieve this String of values
        Method getNativeParams = camClass.getDeclaredMethod("native_getParameters");
        getNativeParams.setAccessible(true);

        //Boom. Here's the raw String from the hardware
        String rawParamsStr = (String) getNativeParams.invoke(cam);

        //But let's do better. Here's what Android uses to parse the
        //String into a usable Map -- a simple ';' StringSplitter, followed
        //by splitting on '='
        //
        //Taken from Camera.Parameters unflatten() method
        TextUtils.StringSplitter splitter = new TextUtils.SimpleStringSplitter(';');
        splitter.setString(rawParamsStr);

        for (String kv : splitter) {
            int pos = kv.indexOf('=');
            if (pos == -1) {
                continue;
            }
            String k = kv.substring(0, pos);
            String v = kv.substring(pos + 1);
            result.put(k, v);
        }

        //And voila, you have a map of ALL supported parameters
        return result;
    } catch (NoSuchMethodException ex) {
        Log.e(TAG, ex.toString());
    } catch (IllegalAccessException ex) {
        Log.e(TAG, ex.toString());
    } catch (InvocationTargetException ex) {
        Log.e(TAG, ex.toString());
    }

    //If there was any error, just return an empty Map
    Log.e(TAG, "Unable to retrieve parameters from Camera.");
    return result;
}