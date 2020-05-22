import com.mchange.v2.c3p0.*;

static void printInnerStatement( C3P0ProxyStatement stmt )
{
   java.lang.reflect.Method m = java.io.PrintStream.class.getMethod("println", new Class[]{Object.class});
   stmt.rawStatementOperation(m, System.out, new Object[]{ C3P0ProxyStatement.RAW_STATEMENT });
}