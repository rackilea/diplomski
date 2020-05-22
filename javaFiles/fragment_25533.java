@Override
public Object visitUnit(UnitContext ctx) {

    String unitId = ctx.ID();

    try{ 
         // Next line will throw exception if unitId is not
         // the name of one of your enums.
         UnitMeasures unit = UnitMeasures.valueOf(unitId);

         // do something maybe?

    } catch (IllegalArgumentException(e) {
        throw new RuntimeException("Invalid unit: " + unitId);
    }

    return super.visitUnit(ctx);
}