<form action="#" th:action="@{/addExam}"  th:object="${exam}" method="post">

<select th:field="*{subject}" class="form-control" id="subject" name="subject">
    <option value="">Select subject</option>
    <option 
        th:each="Subject : ${subjects}" 
        th:value="${Subject}" 
        th:text="${Subject}"></option>
    <table>
        <tr>
        <td> Exam Title:</td>
         <td><input type="text" th:field="*{examTitle}" /></td>

        </tr>  
        <tr>
            <td> Exam grade worth </td>
            <td><input th:field="*{examGradeWorth}" /></td>

            </tr>  
            <tr>
                <td><button type="submit">Submit post</button></td>
                </tr>
    </table>
    </div>
</form>