String buildXml = "build.xml";
Project p = new Project();
p.setUserProperty("ant.file", buildXml);
p.init();
ProjectHelper helper = ProjectHelper.getProjectHelper();
p.addReference("ant.projectHelper", helper);
InputStream inputStream = new FileInputStream(buildXml);
helper.parse(p, inputStream);
p.executeTarget(p.getDefaultTarget());