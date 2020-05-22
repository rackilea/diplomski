<!DOCTYPE html>
<html lang="en"><FORM>
<head>
<script>
function test() {
    var app = document.applet_test;
    alert("Screen Dimension\r\n  width:" + app.getScreenWidth()
      + " height:" + app.getScreenHeight());
}
</script>
<body>
<INPUT type="button" value="call JAVA"
   onClick = "test()">
</FORM>
<object name="applet_test" type="application/x-java-applet" height="300" width="550" >
<param name="code" value="loader.class"/>
</object>
</body>
</html>