public class Tester implements Runnable {
    private WebDriver browser;

    public Tester(WebDriver browser) {
        this.browser = browser;
    }

    public static void main(String[] args) {    

      Thread worker1 = new Thread(new Tester(new FirefoxDriver(firefoxProfile)));
      Thread worker2 = new Thread(new Tester(new FirefoxDriver(firefoxProfile)));

      worker1.start();
      worker2.start();            
    }

    public void run() {
        login(browser, "username", "password", "http://someurl.com/login");
    }

}