Class<?> c = Class.forName("android.os.SystemProperties");
Method get = c.getMethod("get", String.class);
String miui = (String) get.invoke(c, "ro.miui.ui.version.code");
if (!miui.isEmpty() && Build.VERSION.SDK_INT >= 28) {
            PermissionData mPopup = new PermissionData();
            mPopup.text = "Other permissions > Display pop-up while in background";
            mPopup.onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            };

            mPermissionData.add(mPopup);
}