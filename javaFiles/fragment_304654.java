<html> 
<head>
<script language="javascript"> 

function access(){ 
  <% String str="Hello World"; %>
   var s="<%=str%>"; 
   alert(s); 
} 

</script> 
</head> 

<body onload="access()"> 
</body> 

</html>