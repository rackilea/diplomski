override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context)
{
    // Add field of type String
    annotatedClass.addField("stringField") [
        type = string // Get TypeReference to type String
    ]
}