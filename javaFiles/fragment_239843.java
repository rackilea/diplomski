DeploymentInfo deploymentInfo = Servlets.deployment()
            .setClassLoader(classLoader)
            .setContextPath("/rest/")
            .setDeploymentName(DEPLOYMENT_NAME)
            .addServlet(
                    Servlets.servlet("RestServlet", CamelHttpTransportServlet.class)
                            .addMapping("/*")
                            .setLoadOnStartup(1)
            );