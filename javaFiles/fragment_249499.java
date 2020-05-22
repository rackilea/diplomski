<div id="loadedImages" style="display: inline-block;">
  <c:url var="firstURL"
    value="/ImageServlet?imageId=First.jpg" />
  <img alt="First image" src="${firstURL}" />

  <c:url var="secondURL"
    value="/ImageServlet?imageId=Second.jpg" />
  <img alt="Second image" src="${secondURL}" /> 
</div>