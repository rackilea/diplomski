List<Bundle> installedBundles = new ArrayList<Bundle>();
for (URL url : urls) {
    installedBundles.add(context.installBundle(url.toString()));
}
for (Bundle bundle : installedBundles) {
    bundle.start();
}