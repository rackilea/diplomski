try {
            Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
            for (String contextName : contextNames) {
                System.out.println(contextName);
                if (contextName.contains("WEBVIEW")) {
                    ((AppiumDriver<MobileElement>) driver).context(contextName);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();            
        }