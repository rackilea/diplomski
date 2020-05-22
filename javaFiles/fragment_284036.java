public class SimplangTest {

    public static void main(String[] args) {

        ANTLRInputStream input = new ANTLRInputStream(
                "var x = 4;\nfoo(x, 10);\nbar(y + 10 - 1, 'x' + 'y' + 'z');");

        SimplangLexer lexer = new SimplangLexer(input);

        SimplangParser parser = new SimplangParser(new CommonTokenStream(lexer));

        parser.addParseListener(new SimplangBaseListener() {
            public void exitArg(SimplangParser.ArgContext ctx) {
                System.out.print(", ");
            }

            public void exitCall(SimplangParser.CallContext call) {
                System.out.print("})");
            }

            public void exitMethodName(SimplangParser.MethodNameContext ctx) {
                System.out.printf("call(\"%s\", new Object[]{", ctx.ID()
                        .getText());
            }

            public void exitCallStatement(SimplangParser.CallStatementContext ctx) {
                System.out.println(";");
            }

            public void enterDecl(SimplangParser.DeclContext ctx) {
                System.out.print("define(");
            }

            public void exitVariableName(SimplangParser.VariableNameContext ctx) {
                System.out.printf("\"%s\", ", ctx.ID().getText());
            }

            public void exitDeclStatement(SimplangParser.DeclStatementContext ctx) {
                System.out.println(");");
            }

            public void exitAdd_op(SimplangParser.Add_opContext ctx) {
                if (ctx.MINUS() != null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" + ");
                }
            }

            public void exitPrimary_expr(SimplangParser.Primary_exprContext ctx) {
                if (ctx.string != null) {
                    String value = ctx.string.getText();
                    System.out.printf("\"%s\"",
                            value.subSequence(1, value.length() - 1));
                } else if (ctx.altNum == 2){    //cheating and using the alt# for "INT"
                    System.out.printf("read(\"%s\")", ctx.id.getText());
                } else {
                    System.out.print(ctx.INT().getText());
                }
            }
        });

        parser.compilationUnit();
    }
}