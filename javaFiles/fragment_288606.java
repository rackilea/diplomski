public SwaggerSpecificationRestlet getSwaggerSpecificationRestlet(
                 Context context) {
    SwaggerSpecificationRestlet result
               = new SwaggerSpecificationRestlet(this) {
        protected void filterDefinition(Definition definition) {
            (...)
        }
    };
    result.setApiInboundRoot(this);
    return result;
}