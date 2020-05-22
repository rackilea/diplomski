boolean autoGenerateTitleForProperties = false;
String defaultArrayFormat = null;
boolean useOneOfForOption = true;
boolean useOneOfForNullables = false;
boolean usePropertyOrdering = false;

boolean hidePolymorphismTypeProperty = false;
boolean disableWarnings = false;
boolean useMinLengthForNotNull = false;
boolean useTypeIdForDefinitionName = false;
boolean useMultipleEditorSelectViaProperty = false;
Set<Class<?>> uniqueItemClasses = Collections.emptySet();

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

Map<Class<?>, Class<?>> classTypeReMapping = new HashMap<>();
classTypeReMapping.put(LocalDate.class, String.class);
// #####****##### Add remapped types here 

Map<String, String> typeToFormatMapping = new HashMap<>();
typeToFormatMapping.put(LocalDate.class.getName(), "date");
// #####****##### (optional) Add format annotations for types here 

JsonSchemaConfig config = JsonSchemaConfig.create(
        autoGenerateTitleForProperties,
        Optional.ofNullable(defaultArrayFormat),
        useOneOfForOption,
        useOneOfForNullables,
        usePropertyOrdering,
        hidePolymorphismTypeProperty,
        disableWarnings,
        useMinLengthForNotNull,
        useTypeIdForDefinitionName,
        typeToFormatMapping,
        useMultipleEditorSelectViaProperty,
        uniqueItemClasses,
        classTypeReMapping,
        Collections.emptyMap()
)