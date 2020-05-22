public Observable<AppModel> getMyAppList(final PackageManager pm, List<ApplicationInfo> list){



    return Observable
            .from(list)
            .subscribeOn(Schedulers.computation())
            .map(new Func1<ApplicationInfo, AppModel >() {
                @Override
                public AppModel call(ApplicationInfo applicationInfo) {
                    AppModel mm = new AppModel();
                    mm.set_id(applicationInfo.hashCode());
                    mm.setApp_name(""+applicationInfo.loadLabel(pm));
                    mm.setPackage_name(""+applicationInfo.packageName);
                    mm.setIcon(applicationInfo.loadIcon(pm));

                    return mm;
                }
            });
}