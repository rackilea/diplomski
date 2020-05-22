<html>
<head>

<script>
    var showData = function() {
        var data = android.getData();
        data=JSON.parse(data);
         var data1 = android.getLong();
        data1=JSON.parse(data1);
        window.alert("Hello! Data are: " + data );
        window.alert("Hello! Data are: " + data1 );
    }

 </script>

   </head>

 <body>

    <input type="button" value="Display data" onclick="showData()">


    <input type="button" value="Done" onclick="android.finish();">

     </body>
      </html>