/*
 * preforms some calculations on the codesets we have in order to make them work with certain models of phone.
 *
 * HTC devices need formula 1
 * Samsungs want formula 2
 *
 * Samsung Pre-4.4.3 want nothing, so just return the input data
 *
 */
private static int[] string2dec(int[] irData, int frequency) {
    int formula = shouldEquationRun();

    //Should we run any computations on the irData?
    if (formula != 0) {
        for (int i = 0; i < irData.length; i++) {
            if (formula == 1) {
                irData[i] = irData[i] * (1000000/frequency);//the brackets should avoid an arithmetic overflow
            } else if (formula == 2) {
                irData[i] = (int) Math.ceil(irData[i] * 26.27272727272727); //this is the samsung formula as per http://developer.samsung.com/android/technical-docs/Workaround-to-solve-issues-with-the-ConsumerIrManager-in-Android-version-lower-than-4-4-3-KitKat
            }
        }
    }
    return irData;
}

/*
 * This method figures out if we should be running the equation in string2dec,
 * which is based on the type of device. Some need it to run in order to function, some need it NOT to run
 *
 * HTC needs it on (HTC One M8)
 * Samsung needs occasionally a special formula, depending on the version
 * Android 5.0+ need it on. 
 * Other devices DO NOT need anything special.
 */
private static int shouldEquationRun() {
    //Some notes on what Build.X will return
    //System.out.println(Build.MODEL); //One M8
    //System.out.println(Build.MANUFACTURER); //htc
    //System.out.println(Build.VERSION.SDK_INT); //19

    //Samsung's way of finding out if their OS is too new to work without a formula:
    //int lastIdx = Build.VERSION.RELEASE.lastIndexOf(".");
    //System.out.println(Build.VERSION.RELEASE.substring(lastIdx+1)); //4

    //handle HTC
    if (Build.MANUFACTURER.equalsIgnoreCase("HTC")) {
        return 1;
    }
    //handle Lollipop (Android 5.0.1 == SDK 21) / beyond
    if (Build.VERSION.SDK_INT >= 21) {
        return 1;
    }
    //handle Samsung PRE-Android 5
    if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
        if (Build.VERSION.SDK_INT >= 19) {
            int lastIdx = Build.VERSION.RELEASE.lastIndexOf(".");
            int VERSION_MR = Integer.valueOf(Build.VERSION.RELEASE.substring(lastIdx + 1));
            if (VERSION_MR < 3) {
                // Before version of Android 4.4.2
                //Note: NO formula here, not even the other one
                return 0;
            } else {
                // Later version of Android 4.4.3
                //run the special samsung formula here
                return 2;
            }
        }
    }
    //if something else...
    return 0;
}