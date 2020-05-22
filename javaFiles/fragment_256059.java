// Assuming this static import
import static org.jooq.impl.DSL.*;

// Aliasing
Users u = USERS.as("u");

// You didn't qualify all your columns, so I'm assuming DATA is in LOG
DSL.using(configuration)
   .select(
        coalesce(u.NAME, jsonAttr(LOG.DATA, "username")).as("username"),
        u.USER_LOCATION,
        u.USER_TIME)
   .from(LOG)
   .leftJoin(u)
       .on(jsonAttr(LOG.DATA, "username").isNotNull())
       .and(jsonAttr(LOG.DATA, "username").eq(u.USERNAME))
   .where(jsonAttr(LOG.DATA, "code").isNull())
   .or(jsonAttr(LOG.DATA, "code").ne("no"))
   .fetch();