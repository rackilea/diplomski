<c:if test="{not empty account}">
   <!--If you need a BigDecimal PropertyEditor-->
   <spring:bind path="command.bigDecimal">
       <spring:transform value="${account.balance}"/>
   </spring:bind>
   <!--If you need a Date PropertyEditor-->
   <spring:bind path="command.date">
       <spring:transform value="${account.joinedDate}"/>
   </spring:bind>
</c:if>