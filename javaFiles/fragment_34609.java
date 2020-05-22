<c:forEach items= "${cookie}" var="currentCookie">
                        <c:if test="${currentCookie.key eq 'user_type' }">
                            <c:set var="user_type" value = "${currentCookie.value.value }"/>

                        </c:if>
                    </c:forEach> 

      <c:if test="${user_type eq 'T' || user_type eq 'P'}"> 
                             <li><a href="/myproject/f/auction_history/">My Account</a></li>
                    </c:if>                                         
                    <c:if test="${user_type eq 'D'}">
                             <li><a href="/myproject/f/menubarCreateAuction/">Create Auction</a></li>
                    </c:if>
                    <c:if test="${user_type eq 'F'}">
                             <li><a href="/myproject/f/menubarDfoManagement/">DFO Management</a></li>
                    </c:if>
                    <c:if test="${user_type eq 'S'}">
                             <li><a href="/myproject/f/menubaruserManagement/">User Management</a></li>
                    </c:if>