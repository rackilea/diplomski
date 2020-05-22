<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">
    var id;

    function fun() {
        alert("aaaa");
        id = 1;

        $.ajax({
            type : "POST",
            data : {
                reqValue : id
            },
            url : "/WebProject/callAjax"
        });
    }
</script>
</head>
<body>
    <button id="scan" onclick="fun()">Sacn</button>
</body>
</html>