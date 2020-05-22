int type = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }