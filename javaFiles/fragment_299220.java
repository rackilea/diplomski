<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
    </script>
<script type="text/javascript">
        $(document).ready(function() {

            //alert("DOM is ready");

        });

        function sendData() {

            $.ajax({
                type : 'POST',
                url : "TableAppend",
                data : "name=" + $('#name').val() + "&age=" + $('#age').val()
                        + "&sid=" + new Date(),
                dataType : 'html',
                success : function(result) {
                    //alert("Result ::::>>> "+result);
                    if(result != null && $.trim(result) != "" && result != undefined){
                        var json = JSON.parse(result);
                        //alert(json.name);
                        //alert(json.age);
                        appendToTable(json.name, json.age);
                    }

                },
                error : function(e) {
                    alert('Error in Processing');
                }

            });
        }

        function appendToTable(name, age) {
            var tr = "<tr><td>" + name + "</td><td>" + age + "</td></tr>"
            $('#mytable').append(tr);
        }
    </script>
</head>
<body>
    Name :
    <input type="text" id="name" name="name" /> Age :
    <input type="text" id="age" name="age" />

    <input type="button" value="Append to table" onclick="sendData()">
    <br></br>
    <br></br>
    <br></br>
    <table id="mytable" border="1">
        <tbody>
            <tr>
                <th>Name</th>
                <th>Age</th>
            </tr>
            <tr>
                <td>HumanBeing</td>
                <td>25</td>
            </tr>
            <tr>
                <td>Saideep</td>
                <td>26</td>
            </tr>
        </tbody>
    </table>

</body>
</html>