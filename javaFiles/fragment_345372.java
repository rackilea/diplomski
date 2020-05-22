<script language="javascript" type="text/javascript">
     var  type = '${element.type}'; // is it necessary?
     <c:if test="${element.type == 'type1'}">
         var variable = '${element.variable}';
     </c:if>
     <c:if test="${element.type == 'type2'}">
         var message = '${element.noContentMessage}';
     </c:if>
</script>