<jx:forEach items="${group.items}"  groupBy="client">     
 <jx:forEach items="${group.items}"  groupBy="contract">    
  <jx:forEach items="${group.items}" var="result">   
  PREMIUM  
  ${result.premium}  
  </jx:forEach>  
 Group Total $[SUM(I18)]  
 </jx:forEach>   
 ${sum(premium):group.items} 
</jx:forEach>