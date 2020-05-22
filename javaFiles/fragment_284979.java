<% List<String> strList = new ArrayList<String>();
    strList.add("one");
    strList.add("two");
    strList.add("three"); %>

    <script type="text/javascript">

    $(document).ready(function() {

        var notes = new Array();
        <%
        for(String note:strList){
        %>
        notes.push('<%=note%>');
        <%}%>
        alert(notes);
    });
    </script>