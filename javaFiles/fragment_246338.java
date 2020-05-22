<?-- APPIUM_NODEJS_LISTENING_PORT = 4723 SERVERS <--port, --callback-port 4723> 
    Mobile « http://127.0.0.1:4723/wd/hub
    Desktop « http://localhost:4444/wd/hub
-->
[36minfo[39m: Appium REST http interface listener started on 127.0.0.1:1750
[36minfo[39m: [debug] Non-default server args: 
{
    "address":"127.0.0.1",
    "port":1750,
    "bootstrapPort":7119,
    "sessionOverride":true,
    "log":"D:\\Yash\\MyConsole_TA64301YVY.txt",
    "chromeDriverPort":7115
}


<?-- LIST OF CONNECTED DEVICES [UDID]
Unique device identifier of the connected physical device
To connect specific named device in the list of connected devices use UDID
-->
[36minfo[39m: [debug] Trying to find a connected android device
[36minfo[39m: [debug] Getting connected devices...
[36minfo[39m: [debug] executing cmd: D:\Android\sdk\platform-tools\adb.exe devices
[36minfo[39m: [debug] 2 device(s) connected
[36minfo[39m: Found device TA64301YVY
[36minfo[39m: [debug] Setting device id to TA64301YVY

<?-- 
BOOTSTRAP  = 4724 Socket tcp port to use on device to talk to Appium
        « Forwarding system:4724 to device:4724   appium bootstrap to device
-->
[36minfo[39m: [debug] Forwarding system:7119 to device:4724
[36minfo[39m: [debug] executing cmd: D:\Android\sdk\platform-tools\adb.exe -s TA64301YVY forward tcp:7119 tcp:4724
[36minfo[39m: [debug] Pushing appium bootstrap to device...


<?-- 
Chrome debugger server to connect to, in the form of <hostname/ip:port>
CHROME_DRIVER  = 9515 Port upon which ChromeDriver will run
-->
[36minfo[39m: Chromedriver: Spawning chromedriver with: C:\Program Files (x86)\Appium\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win\chromedriver.exe --url-base=wd/hub --port=7115
[36minfo[39m: Chromedriver: [STDOUT] Starting ChromeDriver 2.18.343845 (73dd713ba7fbfb73cbb514e62641d8c96a94682a) on port 7115

APPLICATION URL:
[36minfo[39m: JSONWP Proxy: Proxying [POST /wd/hub/session/SESSION-ID/url] to [POST http://127.0.0.1:7115/wd/hub/session/SESSION-ID/url] with body: {"url":"http://www.w3schools.com/"}
[36minfo[39m: JSONWP Proxy: Got response with status 200: {"sessionId":"SESSION-ID","status":0,"value":null}

WEB ELEMENT:
[36minfo[39m: JSONWP Proxy: Proxying [POST /wd/hub/session/SESSION-ID/element] to [POST http://127.0.0.1:7115/wd/hub/session/SESSION-ID/element] with body: {"using":"xpath","value":"//body/div[4]/div[1]/div[1]/a[1]"}
[36minfo[39m: JSONWP Proxy: Got response with status 200: {"sessionId":"SESSION-ID","status":0,"value":{"ELEMENT":"0.39628730167672455-1"}}

WEB ELEMENT & ACTION:
[36minfo[39m: JSONWP Proxy: Proxying [POST /wd/hub/session/SESSION-ID/element/0.39628730167672455-1/click] to [POST http://127.0.0.1:7115/wd/hub/session/SESSION-ID/element/0.39628730167672455-1/click] with body: {"id":"0.39628730167672455-1"}
[36minfo[39m: JSONWP Proxy: Got response with status 200: {"sessionId":"SESSION-ID","status":0,"value":null}