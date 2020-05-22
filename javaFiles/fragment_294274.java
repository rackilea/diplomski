ArrayInitializer:
    { VariableInitializersopt ,opt }

VariableInitializers:
    VariableInitializer
    VariableInitializers , VariableInitializer  

VariableInitializer:
    Expression
    ArrayInitializer