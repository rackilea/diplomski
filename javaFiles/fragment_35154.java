10-24 20:31:04.994 2346-2346/? E/SQLiteLog: (14) cannot open file at line 30046 of [9491ba7d73]
10-24 20:31:04.994 2346-2346/? E/SQLiteLog: (14) os_unix.c:30046: (2) open(/data/data/mjt.joblist/databases/JobList) - 
10-24 20:31:04.994 2346-2346/? E/SQLiteDatabase: Failed to open database '/data/data/mjt.joblist/databases/JobList'.
                                                 android.database.sqlite.SQLiteCantOpenDatabaseException: unknown error (code 14): Could not open database
                                                     at android.database.sqlite.SQLiteConnection.nativeOpen(Native Method)
                                                     at android.database.sqlite.SQLiteConnection.open(SQLiteConnection.java:209)
                                                     at android.database.sqlite.SQLiteConnection.open(SQLiteConnection.java:193)
                                                     at android.database.sqlite.SQLiteConnectionPool.openConnectionLocked(SQLiteConnectionPool.java:463)
                                                     at android.database.sqlite.SQLiteConnectionPool.open(SQLiteConnectionPool.java:185)
                                                     at android.database.sqlite.SQLiteConnectionPool.open(SQLiteConnectionPool.java:177)
                                                     at android.database.sqlite.SQLiteDatabase.openInner(SQLiteDatabase.java:806)
                                                     at android.database.sqlite.SQLiteDatabase.open(SQLiteDatabase.java:791)
                                                     at android.database.sqlite.SQLiteDatabase.openDatabase(SQLiteDatabase.java:694)
                                                     at android.database.sqlite.SQLiteDatabase.openDatabase(SQLiteDatabase.java:669)
                                                     at mjt.joblist.CopyDBFromAssets.checkDataBase(CopyDBFromAssets.java:93)
                                                     at mjt.joblist.CopyDBFromAssets.createDataBase(CopyDBFromAssets.java:25)
                                                     at mjt.joblist.MainActivity.onCreate(MainActivity.java:18)
                                                     at android.app.Activity.performCreate(Activity.java:5990)
                                                     at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1106)
                                                     at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2278)
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
10-24 20:31:05.004 2346-2346/? E/CHECKASSET: Asset JobListcould not be found. Assets that exists are:-  Job images sounds webkit
10-24 20:31:05.004 2346-2346/? E/CREATEDB: Error getting asset JobList
10-24 20:31:05.004 2346-2346/? D/AndroidRuntime: Shutting down VM


                                                 --------- beginning of crash
10-24 20:31:05.004 2346-2346/? E/AndroidRuntime: FATAL EXCEPTION: main
                                                 Process: mjt.joblist, PID: 2346
                                                 java.lang.RuntimeException: Unable to start activity ComponentInfo{mjt.joblist/mjt.joblist.MainActivity}: java.lang.RuntimeException: No Usable Database exists or was copied from the assets.
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
                                                  Caused by: java.lang.RuntimeException: No Usable Database exists or was copied from the assets.
                                                     at mjt.joblist.MainActivity.onCreate(MainActivity.java:27)
                                                     at android.app.Activity.performCreate(Activity.java:5990)
                                                     at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1106)
                                                     at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2278)
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
10-24 20:31:05.008 738-1262/? W/ActivityManager:   Force finishing activity 1 mjt.joblist/.MainActivity