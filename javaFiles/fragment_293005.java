FeatureExportInfo info = new FeatureExportInfo();
info.useJarFormat = true;
info.items = bundlesToExport.toArray(); //bundlesToExport is a ArrayList<IModel>
PluginExportOperation exportJob = new PluginExportOperation(info, "Export selected bundles");
exportJob.setUser(true);
exportJob.setRule(ResourcesPlugin.getWorkspace().getRoot());
exportJob.schedule();