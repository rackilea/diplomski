public class SumVisitor extends listBaseVisitor<Integer> {

    @Override
    public Integer visitList(@NotNull listParser.ListContext ctx) {
        return ctx.elems() == null ? 0 : this.visitElems(ctx.elems());
    }

    @Override
    public Integer visitElems(@NotNull listParser.ElemsContext ctx) {
        int sum = 0;
        for (listParser.ElemContext elemContext : ctx.elem()) {
            sum += this.visitElem(elemContext);
        }
        return sum;
    }

    @Override
    public Integer visitElem(@NotNull listParser.ElemContext ctx) {
        return Integer.valueOf(ctx.NUM().getText());
    }
}