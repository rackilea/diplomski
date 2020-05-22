<script >
var tab = ["hello","world"]; //here is an array for test
$.get("scriptlet.jsp",{ sg:tab  },function(data){
        alert("Data Loaded: " + data);
    }
);
</script>
</head>
<body>
<% 

String[] myArray = request.getParameterValues("sg[]");
out.println(myArray[0]); // this will print you  "hello"
%>

</body>