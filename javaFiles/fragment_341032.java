<table name="urlTable" id="urlList"  style="width:100%; overflow: scroll;">

    <thead>
        <tr>
            <th>Select</th>
            <th>URL</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="urlList" items="${command.urlList}">
        <tr>
            <td><input type="checkbox" name="chk"/></td>
            <td class="urlText"><input class="urlValue" type="text" value="${urlList}" style="font-size: 13px; border: none;" size="85px;" readonly="readonly"/></td>
        </tr>
        </c:forEach>
    </tbody>

</table>