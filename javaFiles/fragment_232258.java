package test;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.visitor.GenericVisitorAdapter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JavaFileParser {

static String strFilePath = null;
static String strMainMethod = null;
static String strMethodName = null; 

private static void dataSetter(String pFilePath, String pMainMethod, String pMethodName) {
    strFilePath = pFilePath;
    strMainMethod = pMainMethod;
    strMethodName = pMethodName;
}

public static ArrayList getMethodParameters(String pFilePath, String pMainMethod, String pMethodName) throws Exception {


    // creates an input stream for the file to be parsed
    ArrayList args1 =  null;

    dataSetter(pFilePath,pMainMethod, pMethodName);
    InputStream in = new FileInputStream(strFilePath);

    CompilationUnit cu;
    try {
        // parse the file
        cu = JavaParser.parse(in);
    } finally {
        in.close();
    }

    // prints the resulting compilation unit to default system output
    args1 =  visit(cu);     

    return args1;
}

private static ArrayList visit(CompilationUnit cu) {
    ArrayList  paramatersList = null;
    List<TypeDeclaration> types = cu.getTypes();
    for (TypeDeclaration type : types) {
        List<BodyDeclaration> members = type.getMembers();
        for (BodyDeclaration member : members) {
            if (member instanceof MethodDeclaration) {
                MethodDeclaration method = (MethodDeclaration) member;
                if (strMainMethod.equals(method.getName())) {
                    BlockStmt body = method.getBody();
                    MyVisitor myVisitor = new MyVisitor();
                    body.accept(myVisitor, null);
                    paramatersList = myVisitor.getParamatersList();
                }
            }
        }
    }

    return paramatersList;
}

private static class MyVisitor extends GenericVisitorAdapter {

    private ArrayList paramatersList= new ArrayList();

    public Object visit(MethodCallExpr n, Object arg) {

        if (strMethodName.equals(n.getName())){
                List<Expression> expressionList = n.getArgs();
                paramatersList.add(expressionList) ;
        }

        return super.visit(n, arg);
    }

    public ArrayList getParamatersList() {
        return paramatersList;
    }

}

}