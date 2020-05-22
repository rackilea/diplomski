// import static org.jooq.impl.DSL.*; is assumed
DSL.using(configuration)
   .selectFrom(Element)
   .whereExists(
      selectOne()
     .from(Tags)
     .join(TagsToElement)
     .on(Tags.TAGID.eq(TagsToElement.TAGID))
     .where(Element.ID.eq(TagsToElement.ELEMENTID))
     .and(Tags.TAGNAME.eq("Specific Name"))
   )