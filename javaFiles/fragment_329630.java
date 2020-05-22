<c:forEach items="${query.rows}" var="result">
     <c:set var="lname" value="${result.lname}"  />
     <c:set var="fname" value="${result.fname}" />

     <%
         ArrayList l= new ArrayList();

         l.add((String)pageContext.getAttribute("fname"));
         l.add((String)pageContext.getAttribute("lname"));

         for(int i=0; i<l.size(); i++)
         {
             out.println(l.get(i));
         }
     %>


</c:forEach>