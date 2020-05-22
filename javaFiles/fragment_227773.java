SchemaCompiler schemaCompiler = XJC.createSchemaCompiler();
schemaCompiler.forcePackageName(packageRoot);

// JAXB Plugin used to get the proper @Size annotations on all fields.
JaxbValidationsPlugins jaxbValidationPlugin = new JaxbValidationsPlugins();

// Build up list of options for the plugin.
// First option must be the name of the plugin itself.
// Options must be prefixed with dashes
String[] args = new String[] { "-" + JaxbValidationsPlugins.PLUGIN_OPTION_NAME };

// Get the options for the schema compiler, this is where we add plugins.
Options schemaCompilerOptions = ((SchemaCompilerImpl) schemaCompiler).getOptions();
schemaCompilerOptions.getAllPlugins().add(jaxbValidationPlugin);

// Call the parseArgument method on the options, not the plugin
// Passing in zero because we want to parse the first argument in the array
try {
    schemaCompilerOptions.parseArgument(args, 0);
} catch (BadCommandLineException e1) {
    e1.printStackTrace();
}

InputSource inputSource = new InputSource(schemaFile.toURI().toString());
schemaCompiler.parseSchema(inputSource);
S2JJAXBModel model = schemaCompiler.bind();

JCodeModel jCodeModel = model.generateCode(null, null);