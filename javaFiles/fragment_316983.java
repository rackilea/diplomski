<table>
<c:forEach var="rrow" items="${ReportInfo.list}"  varStatus="rowCounter">
<tr><td><b>${rrow.subjectCode}</b></td>
    <td>${rrow.MCount}</td>
    <td>${rrow.WCount}</td>
    <td>${rrow.OCount}</td></tr>
</c:forEach>
</table>