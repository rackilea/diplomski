< c:choose>

   <c:when test="${param.ignoreCompress eq 'true'}">
    <jsp:doBody/>
   </c:when>
   <c:otherwise>
    <jsp:doBody var="body" />
    <granule:compress method="${param.ignoreCompress eq 'true' ? 'none':'closure'}" >
        ${body}
    </granule:compress>
 </c:otherwise>
</c:choose>