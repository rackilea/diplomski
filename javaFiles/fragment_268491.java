IJavaProject javaProject = JavaCore.create(project);

List<String> exportPac =getExportPackages(javaProject);
BundleManifest manifest = new BundleManifest();    
manifest.setBundleName(project.getName());
manifest.setBundleSymbolicName(project.getName());
manifest.setBundleDescription(project.getName());
manifest.setBundleVersion("2.0");
manifest.setExportPackagesList(exportPac);
[...]
File manifestFile=new File(metainfPath,"MANIFEST.MF");
FileUtils.createFile(manifestFile, manifest.toString());