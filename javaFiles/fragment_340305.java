<provider
    android:name="android.support.v4.content.FileProvider"
    android:authorities="${applicationId}.MyFileProvider"
    android:exported="false"
    android:grantUriPermissions="true" >
    <meta-data
        android:name="android.support.FILE_PROVIDER_PATHS"
        android:resource="@xml/shared_paths"/>
</provider>