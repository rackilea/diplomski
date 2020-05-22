RawSql rawSql =
  RawSqlBuilder
    .parse(sql)
    .columnMapping("a.id", "id")
    .create();

List<Article> articles = Ebean.find(Article.class)
  .setRawSql(rawSql)
  .setParameter("tags", tags)
  .setParameter("num_tags", tags.length)
  .findList();