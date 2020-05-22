public class PostgresInt4RangeBinding implements Binding<Object, Range<Integer>> {

    @Override
    public Converter<Object, Range<Integer>> converter() {
        return new Int4RangeConverter();
    }

    @Override
    public void sql(BindingSQLContext<Range<Integer>> ctx) throws SQLException {
        ctx.render()
           .visit(DSL.val(ctx.convert(converter()).value()))
           .sql("::int4range");
    }

    // ...
}