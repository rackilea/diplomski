<html>
<head>
<script language="Javascript">
function accessAppletMethod()
{
    document.getElementById("AppletABC").appendText("Applet Method");
}
</script>

<title>Testing</title></head>
<body onload="accessAppletMethod()">

<h1>Javascript acess Applet method</h1>
<applet width=300 height=100 id="AppletABC" 
code="JavaScriptToJava.class">
</applet>

</body>
</html>