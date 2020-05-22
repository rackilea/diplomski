class MyDslUiModule extends AbstractMyDslUiModule {

    @SingletonBinding(eager=true) def Class<? extends MyValidator> bindMyValidator() {
        return MyValidator
    }
}