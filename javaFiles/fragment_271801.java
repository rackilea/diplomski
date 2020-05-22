<% String s[] = request.getAttribute("first_val");
if(s.length>0){
%>
<input value="<%=s[0]%>" name="first_val" type="hidden">
<% } 
else{
// As per your code
}