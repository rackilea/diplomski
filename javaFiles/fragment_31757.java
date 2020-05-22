<spring:bind path="subs.subDevisions[${gridRow.index}].users">
              <c:forEach items="${obj.users}" var="dependenttwo" varStatus="dependentRowtwo">
                <li>
                  <input name="<c:out value="${status.expression}"/>" type="checkbox" class="users" value="<c:out value="${dependenttwo}"/>"/>
                  <c:out value="${dependenttwo}"/>
                </li>
                </c:forEach>
                </spring:bind>

`subs` is a map key name. the value for this key `subs` is a list of my DTO objects which named as `SubDevisonDto `