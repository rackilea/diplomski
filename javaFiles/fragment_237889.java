<s:iterator id="catIter"  value="categoryList" status="catstatu">      
  <s:iterator value="nameDetailList.{ ?this.categoryId==#catIter.categoryId}">
     <s:if test="#catstatus.first==true">
          <s:property value="categoryName"/>
     </s:if>
    <s:property value="Name"/>
  </s:iterator>
</s:iterator>