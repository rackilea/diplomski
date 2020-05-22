dependencies{
....
//make sure are both same version (8.4.0 or 9.2.1 in my case)
compile 'com.google.android.gms:play-services-gcm:9.2.1'
// this is the one I changed:  compile 'com.google.android.gms:play-services-location:8.4.0'
compile 'com.google.android.gms:play-services-location:9.2.1' // it was 8.4.0
....
}