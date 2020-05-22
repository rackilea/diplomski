<c:forEach var="starCounter" begin="1" end="5">
        <c:set var="starHalfStepCounter" value="${starCounter - 0.5}" />                                        
        <c:choose>
            <c:when test="${starCounter le averageRating}">
                <i class="glyphicon glyphicon-star"></i>
            </c:when>                                       
            <c:when test="${starCounter gt averageRating}">                                             
                <c:choose>
                    <c:when test="${starHalfStepCounter le averageRating}">                                                     
                        <i class="glyphicon glyphicon-star half"></i>
                    </c:when>
                    <c:otherwise>
                        <i class="glyphicon glyphicon-star-empty"></i>
                    </c:otherwise>                                              
                </c:choose>
            </c:when>
        </c:choose>
    </c:forEach>