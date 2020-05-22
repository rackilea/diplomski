WebAppContext webAppContext = new WebAppContext();
                    webAppContext.setResourceBase(webApp.appDir);
                    webAppContext.setDescriptor(webApp.appDir
                            + "/WEB-INF/web.xml");
                    webAppContext.setContextPath(webApp.contextPath);
                    webAppContext.setParentLoaderPriority(true);
                    // webAppContext.setWar(webApp.appDir);
                    //webAppContext.setVirtualHosts(webApp.hostName);