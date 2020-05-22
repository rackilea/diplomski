<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Test</h1>
        <input type="text" id="hide" />
        <input type="text" id="message"/>
        <button id="button">test</button>
        <div id="messageDisplayArea"></div>


        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <script>
        $('#button').on('click', sendMessage);

        function sendMessage() {
            var intxnId = $("#hide").val();
            var message = $("#message").val();
            alert("send  : \n intxnId : " + intxnId + "\nmessage : " + message);
            $.ajax({
                type: "POST",
                cache: false,
                url: "${pageContext.request.contextPath}/test",
                async: true,
                data: "intxnId=" + intxnId + "&message=" + encodeURIComponent(message),
                success: function(response) {

                    if (response !== null && response !== "" && response !== "null") {
                        alert("Name : " + response.name + "\nMessage : " + response.message + "\ntime : " + response.time);
                        $("#messageDisplayArea").append(message);
                    }

                },
                error: function(e) {
                    alert('Error: ' + e);
                },
            });
        }
    </script>
    </body>

</html>