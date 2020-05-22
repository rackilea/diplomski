[main]
...
onlynot=edu.eci.cvds.security.OnlyNotAutenticated ; path of you filter
onlynot.welcomeurl=/bienvenida.xhtml ; url redirect if you try go to login.xhtml
[urls]
/=onlynot   ; this is if you <welcome-file> on web.xml is the login page. 
/login.xhtml=onlynot