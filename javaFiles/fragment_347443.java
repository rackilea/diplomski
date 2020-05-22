Field<Integer[]> path = array(MENU.SEQ).as("path");
Field<Integer> level = inline(1).as("level");
Field<String> display = inline("- ").concat(MENU.NAME).as("display");

Table<?> m = name("m").as(
  select(MENU.ID, path, MENU.NAME, level, display)
 .from(MENU)
 .where(MENU.PID.isNull())
 .unionAll(
  select(
    MENU.ID,
    PostgresDSL.arrayAppend(path, MENU.SEQ),
    MENU.NAME,
    level.add(inline(1)),
    repeat(inline("  "), level).concat(inline("- ")).concat(MENU.NAME))
 .from(MENU)
 .join(table(name("m"))).on(field(name("m", "id"), Integer.class).eq(MENU.PID)))
);

ctx.selectFrom(m).orderBy(path).fetch();