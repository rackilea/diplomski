package com.yocto.cheok;

import android.app.ActivityManager;
import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.Process;

import java.util.List;

public class CustomBackupAgent extends BackupAgent {

    private Boolean isRestoreFinished = false;

    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) {
        //NO-OP - abstract method
    }

    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) {
        //NO-OP - abstract method
    }

    @Override
    public void onRestoreFinished() {
        super.onRestoreFinished();

        isRestoreFinished = true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (isRestoreFinished) {
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

            if (activityManager != null) {
                final List<ActivityManager.RunningAppProcessInfo> runningServices = activityManager.getRunningAppProcesses();

                if (runningServices != null &&
                        runningServices.size() > 0 &&
                        runningServices.get(0).processName.equals("com.yocto.cheok")
                ) {
                    Process.killProcess(runningServices.get(0).pid);
                }
            }
        }
    }
}