<%
    String myVar="blabla";
%>
<script type="text/javascript">
    foo();
    function foo() {
        var value = "<%=myVar%>";
        alert(value);
    }
</script>