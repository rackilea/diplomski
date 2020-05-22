<display:column title="Status">
      <c:if test="${txt.statusType == '1'}">
        Active
      </c:if>
      <c:if test="${txt.statusType == '0'}">
        Passive
      </c:if>
 </display:column>