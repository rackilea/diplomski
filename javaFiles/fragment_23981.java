02-21 10:17:25.975 7604-7604/so.cdfa D/VERSION: Build Version is 22
02-21 10:17:25.975 7604-7604/so.cdfa D/DBPATH: DB Path is /data/data/so.cdfa/databases/db
02-21 10:17:25.975 7604-7604/so.cdfa D/DBPATH: DB Path is /data/data/so.cdfa/databases/db
02-21 10:17:25.976 7604-7604/so.cdfa D/COPYDATABASE: Initiated Copy of the database file db from the assets folder.
02-21 10:17:25.976 7604-7604/so.cdfa D/COPYDATABASE: Asset file db found so attmepting to copy to /data/data/so.cdfa/databases/db
02-21 10:17:25.976 7604-7604/so.cdfa D/DBPATH: path is /data/data/so.cdfa/databases/db
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err: java.io.FileNotFoundException: /data/data/so.cdfa/databases/db: open failed: ENOENT (No such file or directory)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at libcore.io.IoBridge.open(IoBridge.java:456)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at java.io.FileOutputStream.<init>(FileOutputStream.java:87)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at java.io.FileOutputStream.<init>(FileOutputStream.java:72)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at so.cdfa.DBHelper.copyDataBase(DBHelper.java:120)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at so.cdfa.DBHelper.createDataBase(DBHelper.java:58)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at so.cdfa.DBHelper.<init>(DBHelper.java:32)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at so.cdfa.MainActivity.onCreate(MainActivity.java:60)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at android.app.Activity.performCreate(Activity.java:5990)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1106)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2278)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2387)
02-21 10:17:25.976 7604-7604/so.cdfa W/System.err:     at android.app.ActivityThread.access$800(ActivityThread.java:151)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1303)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at android.os.Handler.dispatchMessage(Handler.java:102)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at android.os.Looper.loop(Looper.java:135)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at android.app.ActivityThread.main(ActivityThread.java:5254)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at java.lang.reflect.Method.invoke(Native Method)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at java.lang.reflect.Method.invoke(Method.java:372)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err: Caused by: android.system.ErrnoException: open failed: ENOENT (No such file or directory)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at libcore.io.Posix.open(Native Method)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at libcore.io.BlockGuardOs.open(BlockGuardOs.java:186)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:     at libcore.io.IoBridge.open(IoBridge.java:442)
02-21 10:17:25.977 7604-7604/so.cdfa W/System.err:  ... 19 more
02-21 10:17:25.977 7604-7604/so.cdfa D/AndroidRuntime: Shutting down VM
02-21 10:17:25.977 7604-7604/so.cdfa E/AndroidRuntime: FATAL EXCEPTION: main
    Process: so.cdfa, PID: 7604
    java.lang.RuntimeException: Unable to start activity ComponentInfo{so.cdfa/so.cdfa.MainActivity}: java.lang.RuntimeException: Error copying database (see stack-trace above)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2325)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2387)
        at android.app.ActivityThread.access$800(ActivityThread.java:151)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1303)
        at android.os.Handler.dispatchMessage(Handler.java:102)
        at android.os.Looper.loop(Looper.java:135)
        at android.app.ActivityThread.main(ActivityThread.java:5254)
        at java.lang.reflect.Method.invoke(Native Method)
        at java.lang.reflect.Method.invoke(Method.java:372)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698)
     Caused by: java.lang.RuntimeException: Error copying database (see stack-trace above)
        at so.cdfa.DBHelper.createDataBase(DBHelper.java:65)