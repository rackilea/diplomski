@Resource
ConversionService conversionService;

// ...

Object castedOperand = conversionService.convert(operand, column.getJavaType());