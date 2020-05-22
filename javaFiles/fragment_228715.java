<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="javax.jdo.Query"%>
<%@ page import="com.pack.*"%>




<html>
<head>
<style>
#entryList {
margin-left: 1100px;
margin-top: -325px;
overflow-y: scroll;
height: 630px;
}

</style>
</head>
<body>




<div id="entry" class="entry">
    <h1>Welcome</h1>

    <form action="/LoginServlet" method="post">

        Comments:<br> <br>
        <textarea rows="4" cols="50" name="content">

       </textarea>
        <br> <br> Your name:<br> <br> <input
            name="poster" type="text" value=""><br> <br> <input
            type="submit" value="Post"> <br> <br>

    </form>

</div>
<div id="entryList">


    <h2>Updates</h2>

    <%
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query q1 = pm.newQuery("SELECT FROM " + Entry.class.getName());
        q1.setOrdering("l desc");

        entries = (List<Entry>) q1.execute();
    %>

    <%
        if (entries.isEmpty()) {
    %>

    No entries

    <%
        } else {
    %>

    <%
            for (Entry e : entries) {

    %>

    <%=e.getContent().getValue()%>

    <br> posted by

    <%=e.getPoster()%>

    <br>
    <br> <br>


    <%

                }
            }

    %>

</div>

</body>
</html>