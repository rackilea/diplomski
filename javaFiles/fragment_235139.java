<logic:iterate id="vStudentList" name="reqStudentAttendanceList" 
          type="form.StudentForm" scope="request" indexId="i" >
    <td>
        <span>
            <c:if test="${i > 1 && reqStudentAttendanceList[i-1].roll_no != reqStudentAttendanceList[i-2].roll_no}">
                <bean:write name="vStudentList" property="roll_no"/>
            </c:if>
        </span>
    </td>
    <td>
        <span>
            <c:if test="${i > 1 && reqStudentAttendanceList[i-1].student_name != reqStudentAttendanceList[i-2].student_name}">
                <bean:write name="vStudentList" property="student_name"/>
            </c:if>
        </span>
    </td>
    <td>
        <span>
            <bean:write name="vStudentList" property="presentabsent"/>
        </span>
    </td>    <td>
        <span>
            <bean:write name="vStudentList" property="date"/>
        </span>
    </td>
</logic:iterate>