public SomeEnum get(String key, SomeEnum defaultValue){
    switch(key){
        case "somevalue1" : return SomeEnum.SOME_VALUE_1;
        case "somevalue2" : return SomeEnum.SOME_VALUE_2;
        default: return defaultValue;
    }
}