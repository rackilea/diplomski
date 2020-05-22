public class EqualsTest {
    public static String CONST = "const";
    public void constEqVar(String var) {
        CONST.equals(var);
    }
    public void varEqConst(String var) {
        var.equals(CONST);
    }
}