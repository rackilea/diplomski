out.println("<script>"+
    "var JSONProcess= function(){\n" +
    "var JsonInfo = document.getElementByClassName(\"json\");\n" +
    "var canvasEl = document.getElementById(\"c\");\n" +
    "var nodesData =[];\n"+

    "window.alert(\"This is a test\");\n" +
    "console.log(JsonInfo.length);\n"+
    "for(var i = 0;i<JsonInfo.length; i++)\n" +
    "{\n" +
    "var Json = JsonInfo[x].innerHTML;\n" +
    "if(Json.source == null)\n" +
    "{\n" +
    "nodesData.push([Json.x, Json.y, Json.r, Json.id]);\n" +
    "}\n" +
    "}\n" +
    "for(var i=0; i<nodesData.length; i++)\n" +
    "{\n" +
    "   var data = nodesData[i];\n" +
    "   console.log(data[1]);\n" +
    "   console.log(data[2]);\n" +
    "   console.log(data[3]);\n" +
    "}\n" +
    "}" + 
    "JSONProcess()" + // here
    "</script>");