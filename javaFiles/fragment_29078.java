Starting ChromeDriver 2.43.600210 (68dcf5eebde37173d4027fa8635e332711d2874a) on port 39113
Only local connections are allowed.
dez 12, 2019 4:25:32 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFORMAÇÕES: Detected dialect: OSS
    Dado que o usuário acesse a url do sistema SMAPP Parts and Maintenance          # LoginSteps.queOUsuarioAcesseUrlSistemaSMAPP()
    Entao exibe tela padrão de login por conta Google                               # LoginSteps.exibeTelaPadraoLoginContaGoogle()
      org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //button[text() = 'Esqueceu seu e-mail?'] (tried for 5 second(s) with 500 milliseconds interval)
.
Caused by: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//button[text() = 'Esqueceu seu e-mail?']"}
  (Session info: chrome=78.0.3904.108)
  (Driver info: chromedriver=2.43.600210 (68dcf5eebde37173d4027fa8635e332711d2874a),platform=Windows NT 10.0.17763 x86_64) (WARNING: The server did not provide any stacktrace information)
.
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'
System info: host: 'DESKTOP-AJU29UT', ip: '192.168.12.226', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_221'
Driver info: org.openqa.selenium.chrome.ChromeDriver