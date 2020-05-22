<c:forEach var="facultySubject" items="${facultySubjects}">
                <tr>
                    <td><c:out value="${facultySubject.name}">${facultySubject.name}</c:out>
                    </td>
                    <td><input type="text" name="subject_${facultySubject.id}" value="" /></td>
                </tr>
            </c:forEach>