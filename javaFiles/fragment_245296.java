@Override
public Object accept(JointShapeVisitor v, Object context) {
    return v.visit(this, context);
  }
}

public interface ShapeVisitor{
    public Object visit(CircleObject circle, Object context);
    ..
}