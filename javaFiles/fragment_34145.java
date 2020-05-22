import com.querydsl.core.types.Constant;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.FactoryExpression;
import com.querydsl.core.types.Operation;
import com.querydsl.core.types.ParamExpression;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.core.types.TemplateExpression;
import com.querydsl.core.types.Visitor;


public class ConstantExtractor implements Visitor<Constant<?>, Void>
{

    public static final ConstantExtractor DEFAULT = new ConstantExtractor();


    private ConstantExtractor()
    {
    }


    @Override
    public Constant<?> visit(Constant<?> expr, Void context)
    {
        return expr;
    }


    @Override
    public Constant<?> visit(FactoryExpression<?> expr, Void context)
    {
        return visit(expr.getArgs());
    }


    @Override
    public Constant<?> visit(Operation<?> expr, Void context)
    {
        return visit(expr.getArgs());
    }


    @Override
    public Constant<?> visit(ParamExpression<?> expr, Void context)
    {
        return null;
    }


    @Override
    public Constant<?> visit(Path<?> expr, Void context)
    {
        return null;
    }


    @Override
    public Constant<?> visit(SubQueryExpression<?> expr, Void context)
    {
        return null;
    }


    @Override
    public Constant<?> visit(TemplateExpression<?> expr, Void context)
    {
        return visit(expr.getArgs());
    }


    private Constant<?> visit(List<?> exprs)
    {
        for (Object e : exprs)
        {
            if (e instanceof Expression)
            {
                Constant<?> constant = ((Expression<?>) e).accept(this, null);
                if (constant != null)
                {
                    return constant;
                }
            }
        }

        return null;
    }

   }