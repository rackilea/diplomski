public class NameOfClass {
    {
        // This is an initalization block
    }

    AccessModifier ReturnType nameOfFunction(ParamType nameOfParam) {
        // This is a function body and is not an initialization

        {
          // This introduces scope, is not an initialization
        }
    }
}