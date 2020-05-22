for (Query query : 
    DSL.using(SQLDialect.H2, new Settings().withRenderFormatted())
       .ddl(T_BOOK)
       .queries()) {
    System.out.println(query + ";\n");
}