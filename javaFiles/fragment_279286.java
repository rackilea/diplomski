{
"capabilities":
[
{
"browserName": "Chrome",
"deviceName": "deviceName",
"device": "device",
"udid":"XXXXXXXX",
"version":"X.X.X",
"maxInstances": 5,
"platform":"ANDROID",
"platformName": "Android"
}
],
"configuration":
{
"cleanUpCycle":2000,
"timeout":10000,
"proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy", 
"url":"http://0.0.0.0:4723/wd/hub",
"maxSession": 5,
"port": 4723,
"host": "0.0.0.0",
"register": true,
"registerCycle": 5000,
"hubPort": 4444,
"hubHost": "localhost"
}
}