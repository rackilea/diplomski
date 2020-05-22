class MyResultHandler implements ResultHandler {
    Map<Integer, Map<Integer, ExampleDto>> result = new HashMap<>();
    @Override
    public void handleResult(ResultContext context) { 
        ExampleDto dto = (ExampleDto)context.getResultObject(); 
        Map<Integer, ExampleDto> map = result.get(dto.primaryKey);
        if (map == null) {
            map = new HashMap<>(); 
        }                  
        map.put(dto.secondaryKey, dto);
    }
};
MyResultHandler handler = new MyResultHandler();
ExampleMapper exampleMapper = ...;
exampleMapper.getExampleDtoMap(handler);

return handler.result;