<html xmlns:wicket="http://wicket.apache.org">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
  <div class="container">

    <div wicket:id="posts">
      <h2 wicket:id="title"></h2>
      <p wicket:id="content"></p>
      Posted on <span wicket:id="date"></span>
    </div>

    <div>
      <a wicket:id="recentPosts">&lt;&lt; Recent posts</a>
      <a wicket:id="previousPosts">Previous posts &gt;&gt;</a>
    </div>

  </div>
</body>
</html>