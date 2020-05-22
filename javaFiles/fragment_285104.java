<display:table id="list"   name="display_tbl"                                                                       decorator="checkboxDecorator" form="displ">
 <display:column title="action">    
        <c:url var="url" value="updateFeed">    
          <c:param name="feedKey" value="${list.feedKey}"></c:param> 
        </c:url>
       <a href=${url } title="Update"></a>  

      <c:url var="url1" value="cloneFeed"> 
         <c:param name="cloneFeed" value="${list.cloneFeed}"></c:param> 
      </c:url>  
       <a href=${url1}  title="Clone"></a>

 </display:column>
  </<display:table>