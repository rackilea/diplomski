<c:if test="${fn:length(companies) gt 0}">
   <!--display collection using c:foreach -->
</c:if>

<c:if test="${fn:length(companies) eq 0}">
   Search failed
</c:if>