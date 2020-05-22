public class ExportAsInsert {
    public static void main(String[] args) {
        try (DSLContext ctx = DSL.using(url, user, password)) {
            ctx.meta()
               .getSchemas()
               .stream()

               // Filter out those schemas that you want to export
               .filter(schema -> schema.getName().equals("TEST"))

               // Get the tables for each schema...
               .flatMap(schema -> schema.getTables().stream())

               // ... and format their content as INSERT statements.
               .forEach(table -> System.out.println(ctx.fetch(table).formatInsert()));
        }
    }
}