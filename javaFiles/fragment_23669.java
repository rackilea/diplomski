{
  "capabilities":
      [
        {
          "browserName": "*chrome",
          "maxInstances": 2,
          "seleniumProtocol": "Selenium"
        }
        ... (any other browser capabilities here)
      ],
  "configuration":
  {
    "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "maxSession": 10,
    "port": 5555,
    "register": true,
    "registerCycle": 5000,
    "hubPort": 4444
  }
}