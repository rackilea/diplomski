org.apache.catalina.ant.DeployTask task = new org.apache.catalina.ant.DeployTask();
task.setUrl("http://localhost:8084/manager");
task.setUsername("managerLogin");
task.setPassword("managerPassword");
task.setPath("/UrlToYourDeploadingProject");
task.setWar(new File("c:/Project.war").getAbsolutePath());
task.execute();