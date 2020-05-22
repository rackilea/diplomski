<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Google Books Embedded Viewer API Example</title>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("books", "0");

      function initialize() {
        var viewer = new google.books.DefaultViewer(document.getElementById('viewerCanvas'));
        viewer.load('**ISBN:0738531367**');
      }

      google.setOnLoadCallback(initialize);
    </script>
  </head>
  <body>
    <div id="viewerCanvas" style="width: 600px; height: 500px"></div>
  </body>
</html>