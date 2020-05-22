{
    final {VariableModifierNoFinal} R Identifier = Expression;
    Throwable #primaryExc = null;

    try ResourceSpecification_tail
        Block
    catch (Throwable #t) {
        ...
        #primaryExc = #t;
        throw #t;
    } finally {
       ...
    }
}