@Module
class MyModule {
    @Provides
    MyDependency provideMyDependency() {
        return new MyDependency();
    }
}

@Component(modules = MyModule.class)
interface MyComponent {
    MyDependency myDependency();
}