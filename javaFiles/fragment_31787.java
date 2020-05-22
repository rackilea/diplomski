<html>
<head>
<style>
div.header {
    display: block; text-align: center; 
    position: running(header);
}
div.footer {
    display: block; text-align: center;
    position: running(footer);
}
div.content {page-break-after: always;}
@page {
     @top-center { content: element(header) }
}
@page { 
    @bottom-center { content: element(footer) }
}
</style>
</head>
<body>
    <div class='header'>Header</div>
    <div class='footer'>Footer</div>
    <div class='content'>Page1</div>
    <div>Page2</div>
</body>
</html>