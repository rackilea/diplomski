if (Build.VERSION.SDK_INT >= 21) {
   try {
      StructStat stat = Os.stat("/path/to/my/file");
      if (stat.st_atime != 0) {
           // stat.st_atime contains last access time, seconds since epoch
      }
   } catch (Exception e) {
      // deal with exception
   }
}