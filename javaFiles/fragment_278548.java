<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{base-template}">

<head>
  <title>This page title</title>
</head>

<div layout:fragment="page_content">
  <!-- content for this page -->
</div>

<th:block layout:fragment="scripts">
  <!-- add any scripts related to this page -->
</th:block>
</html>