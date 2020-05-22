<c:forEach var="hasPost" items="${post}">
                <tr>
                    <td>${hasPost.id}</td>
                    <td>${hasPost.image}</td>
                    <td>${hasPost.title}</td>
                    <td>${hasPost.date}</td>
                    <td>${hasPost.description}</td>
                    <td >${hasPost.username}</td>
                </tr>
                </c:forEach>