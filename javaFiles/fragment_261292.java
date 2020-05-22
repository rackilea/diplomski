<c:forEach var="item" items="${attachList}" varStatus="loopCount">
            <c:set var="dispVal" value="false"/>
            <c:forEach items = "${item.roles}" var = "role"> 
                <c:forEach items = "${hotPartRoles}" var = "hpRole"> 
                        <c:if test="${hpRole.id == role.id}">
                      <c:set var="dispVal" value="true"/>
                        </c:if>
                    </c:forEach>
                </c:forEach>

                <tr>

                    <td class="button">
                    <rbac:check operation="<%=Operation.DELETE%>">

                        <button type="button"<c:if test="${dispVal != 'true'}"> disabled="disabled"</c:if>  
                            onclick="javascript:delete_prompt(${item.id});">Delete</button>