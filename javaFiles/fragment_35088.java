package madhav.pmd.rule;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameter;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameters;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclarator;
import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclaratorId;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class ParameterNameConvention extends AbstractJavaRule
{
    private final static String PATTERN = "[p][a-zA-Z]+";

    @Override
    public Object visit(final ASTMethodDeclaration node, final Object pData)
    {
        final RuleContext result = (RuleContext) pData;
        // TODO : get property
        final String rulePattern = PATTERN;
        final ASTMethodDeclarator methodDecNode = node.getFirstChildOfType(ASTMethodDeclarator.class);
        final ASTFormalParameters paramsNode = methodDecNode.getFirstChildOfType(ASTFormalParameters.class);
        if (paramsNode.getParameterCount() > 0)
        {
            for (final ASTFormalParameter element : paramsNode.findChildrenOfType(ASTFormalParameter.class))
            {
                for (final ASTVariableDeclaratorId decElement : element.findChildrenOfType(ASTVariableDeclaratorId.class))
                {
                    if (!decElement.getImage().matches(rulePattern))
                    {
                        addViolationWithMessage(result, node,
                                "Parameter '"
                                        + decElement.getImage()
                                        + "' should match regular expression pattern '"
                                        + rulePattern + "'",
                                node.getBeginLine(),
                                node.getEndLine());
                    }
                }
            }
        }
        return result;
    }
}