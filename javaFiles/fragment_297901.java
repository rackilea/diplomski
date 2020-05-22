Optional<MyEnum> maybeMyEnum = MyEnum.fromDesc(str);
if (maybeMyEnum.isPresent()) {
    switch(maybeMyEnum.get()){
        case EMPLOYEE_NUMBER:
            //setter
            break;
    }
}