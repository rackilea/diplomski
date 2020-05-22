<td>
<s:if test="%{#request.documentationLink != null}">
<a href="<s:property value="#request.documentationLink"/>"target="_blank"
 id="domainName_<s:property value="#rowstatus.index"/>"><s:property value="domainName" />
</a>
</s:if>
<s:else>
<s:property value="domainName" />
</s:else>
</td>