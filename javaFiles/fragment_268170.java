<!DOCTYPE html>
<html lang="en" th:replace="~{layout/applayout.html :: layout(title=~{::title},breadcrumb=~{::ol},content=~{::#main},scripts=~{::#scripts})}" xmlns:th="http://www.thymeleaf.org">
<head>
<title>Homepage</title>
</head>
<body>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item active"><strong>wow</strong></li>
    </ol>
    <div id="main">
        <div class="col">
            <p>WOW</p>
        </div>
        <div class="col">
            <p>WOW</p>
        </div>
        <div class="col">
            <p>WOW</p>
        </div>
    </div>
    <th:block id="scripts">
    </th:block>
</body>
</html>