<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <input type="button" value="Submit" onclick="eliminaUtente('1')" width="100%" />
</body>
<script language="javascript" type="text/javascript">
    function eliminaUtente(id) {

        var xmlHttp = new XMLHttpRequest();
        var url = "test/NewFile.jsp?id=" + id;
        xmlHttp.open("POST", url, true);
        xmlHttp.send(url);
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                alert("utente eliminato!");
            } else {
                alert("An error occurred while communicating with server.");
            }
        };
    }
</script>
</html>