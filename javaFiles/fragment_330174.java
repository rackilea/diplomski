DesiredCapabilities caps = new DesiredCapabilities();
caps.setJavascriptEnabled(true);                
caps.setCapability("takesScreenshot", true);  
caps.setCapability(
                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        "your custom path\\phantomjs.exe"
                    );
WebDriver driver = new  PhantomJSDriver(caps);