System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--test-type");
                    options.addArguments("--headless");
                    options.addArguments("--disable-extensions"); //to disable browser extension popup

                    ChromeDriverService driverService = ChromeDriverService.createDefaultService();
                    ChromeDriver driver = new ChromeDriver(driverService, options);

                    Map<String, Object> commandParams = new HashMap<>();
                    commandParams.put("cmd", "Page.setDownloadBehavior");
                    Map<String, String> params = new HashMap<>();
                    params.put("behavior", "allow");
                    params.put("downloadPath", "//home//vaibhav//Desktop");
                    commandParams.put("params", params);
                    ObjectMapper objectMapper = new ObjectMapper();
                    HttpClient httpClient = HttpClientBuilder.create().build();
                    String command = objectMapper.writeValueAsString(commandParams);
                    String u = driverService.getUrl().toString() + "/session/" + driver.getSessionId() + "/chromium/send_command";
                    HttpPost request = new HttpPost(u);
                    request.addHeader("content-type", "application/json");
                    request.setEntity(new StringEntity(command));
                    httpClient.execute(request);
            driver.get("http://www.seleniumhq.org/download/");
            driver.findElement(By.linkText("32 bit Windows IE")).click();