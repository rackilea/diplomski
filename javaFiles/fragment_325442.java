private SelectQuery<?> getIdeasQuery() {
    Select<?> numComments = dslContext.select(DSL.count().as("comment_count"), COMMENT.IDEA_ID).from(COMMENT).groupBy(COMMENT.IDEA_ID);
    Select<?> numLikes = dslContext.select(DSL.count().as("like_count"), USER_LIKES_IDEA.IDEA_ID).from(USER_LIKES_IDEA).groupBy(USER_LIKES_IDEA.IDEA_ID);

    return dslContext
          .select(DSL.field("comment_count").as("num_comments"))
          .select(DSL.field("like_count").as("num_likes"))
          .select(USER.DISPLAY_NAME)
          .select(USER.AUTHORITY)
          .select(IDEA.fields())
          .from(IDEA.leftOuterJoin(numComments.asTable("com")).on(DSL.field("com.idea_id").eq(IDEA.ID))
                    .leftOuterJoin(numLikes.asTable("like")).on(DSL.field("like.idea_id").eq(IDEA.ID))
                    .leftOuterJoin(USER).on(IDEA.USER_ID.eq(USER.ID)))
          .getQuery();
}