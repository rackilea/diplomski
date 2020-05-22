PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_ALLOW_BACKUP) != 0) {
         // enabled
      } else {
         // disabled
      }