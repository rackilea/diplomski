<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Calendar" %>
<%@page contentType="text/html" import="java.util.*" %>

<!DOCTYPE html>

<html lang="en">

<head>

 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<title>Date Comparison</title>
  <%--
        Note: Including a claender for the user to selcet desired dates    from
  --%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />

 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <script>     
     $(function() {
     $( ".datepicker" ).datepicker();
                  });
</script>

</head>

<body>

    <h1>Select two dates</h1>

        <form action="CalculateDate.jsp" method="post">

            <p>First Date: <input type="date" name="firstdate" class="datepicker" /></p>

            <p>Second Date: <input type="date" name="seconddate" class="datepicker" /></p>

            <input type="submit" value="Calculate">

        </form>

</body>



</html>