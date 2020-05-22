2) Also add following to build.gradle of app : 
    **dependencies {
    ...
    compile (name: 'name_of_aar_file_without_ext', ext:'aar' )
    }**

3) Declare the Activity you want to launch in your apps manifest file : 

    **<activity android:name="com.testmylib.MyActivity" >
    </activity>**

4) Launch your activity as :
        **Intent in = new Intent(NotMyActivity.this,com.testmylib.MyActivity.class)
        startActivity(in);**