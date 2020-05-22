<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
  <head>
    <link href="../../static/css/bootstrap.min.css" th:href="@{css/bootstrap.min.css}" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js" th:src="@{js/bootstrap.min.js}"></script>
    <title layout:title-pattern="$DECORATOR_TITLE - $CONTENT_TITLE">My app</title>
  </head>
  <body>
    <section layout:fragment="content">
        <!-- Content replaced by each page's content fragment -->
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          Praesent scelerisque neque neque, ac elementum quam dignissim interdum.
        </p>
    </section>
  </body>
</html>