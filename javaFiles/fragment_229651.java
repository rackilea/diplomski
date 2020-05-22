<c:choose>
    <c:when test="${developmentMode}">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/custom1.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/custom2.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/another1.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/another2.css"/>"/>
        <script type="text/javascript" src="<c:url value="/js/mylibrary.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/more.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/util.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/whatever.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/more.js"/>"></script>
    </c:when>
    <c:otherwise>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/minified.css"/>"/>
        <script type="text/javascript" src="<c:url value="/js/minified.js"/>"></script>
    </c:otherwise>
</c:choose>