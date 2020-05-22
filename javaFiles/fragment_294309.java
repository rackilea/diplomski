<fmt:parseDate value="${circular.createdOn}" pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ"
                       var="parsedDate" type="date"/>

<fmt:formatDate value="${parsedDate}" var="goodDate"
                       type="both" dateStyle="medium" timeStyle="short"/>

<h1>${goodDate}</h1>