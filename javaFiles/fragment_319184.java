<c:forEach items="${facade.allDetails}" var="theDetail">

    <c:forEach items="${facade.getSomeStuffById('someHardCodedId')}" var="theStuff"> 
        ${theStuff.name} 
    </c:forEach>
</c:forEach>