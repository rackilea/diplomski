<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script type="text/javascript">
    function show() {
        var myElement = document.getElementById('hideQ');
        myElement.style.display = '';
        hideQ();
        return false;
    }
    function hideQ() {
        var myElement = document.getElementById('showQ');
        myElement.style.display = 'none';
    }
</script>
</head>
<body>
<form id="showQ" onsubmit="return show()">
    Insert More Question?<input type="submit" value="Yes" />
    <input type="button" value="No" onclick="window.location.href='Home.jsp';" />
</form>
<form action="saveQuesAdd.do" method="post">
    <table id="hideQ" style="display: none;">
        <tr><td><input name="tableName" hidden="true"     value="${requestScope.table_name}" /></td></tr>
        <tr><td>Question No.</td><td><input type="text" name="question_no" /></td></tr>
        <tr><td>Question:</td><td><textarea rows="3" cols="" name="question">    </textarea></td></tr>
        <tr><td>Option1:</td><td><input type="text" name="option1" /></td></tr>
        <tr><td>Option2:</td><td><input type="text" name="option2" /></td></tr>
        <tr><td>Option3:</td><td><input type="text" name="option3" /></td></tr>
        <tr><td>Option4:</td><td><input type="text" name="option4" /></td></tr>
        <tr><td>Answer:</td><td><input type="text" name="answer" /></td></tr>
        <tr><td><input type="submit" value="Create Database" /></td></tr>
    </table>
    </form>
    </body>
     </html>