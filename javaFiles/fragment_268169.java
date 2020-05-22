<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org" th:fragment="layout"> <!-- ${content} and ${title} are mandatory -->
<head>
<title th:replace="${title}">Application Layout</title>
<th:block th:include="./fragments/head.html :: imports"></th:block>
</head>
<body>
    <div id="wrapper">
        <!-- Sidebar Menu -->
        <div th:replace="./fragments/sidebar.html :: sidebar"></div>
        <div id="page-wrapper" class="gray-bg">
            <!-- Navigation Menu -->
            <div th:replace="./fragments/topbar.html :: topbar"></div>
            <!-- Page Header -->
            <div th:replace="./fragments/pageheader.html :: pageheader(title=${title},breadcrumb=${breadcrumb},actions=${actions})"></div>
            <!-- Main Content -->
            <div class="wrapper wrapper-content animated fadeInUp" th:replace="./fragments/content.html :: content(${content})"></div>
        </div>
    </div>
    <div th:replace="./fragments/footer.html :: footer"></div>
    <th:block th:replace="./fragments/scripts.html :: scripts"></th:block>
</body>
</html>