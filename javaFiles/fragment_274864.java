List<String > pkg_path = new ArrayList<String>();
 List<PackageInfo> pkginfo_list = pm.getInstalledPackages(PackageManager.GET_ACTIVITIES);
 List<ApplicationInfo> appinfo_list = pm.getInstalledApplications(0);
      for (int x=0; x < pkginfo_list.size(); x++){
            PackageInfo pkginfo = pkginfo_list.get(x);
            pkg_path.add(appinfo_list.get(x).publicSourceDir);  //store package path in array
      }