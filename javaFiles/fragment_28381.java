if (driver == null) {
            File fileChrome = new File("src//test/java/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());

            DesiredCapabilities chrome = DesiredCapabilities.chrome();

            try {
                driver = new ChromeDriver(chrome);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("Can't get any browser");
        }