@Module
public final class SampleModule {
  @Qualifier
  @Retention(RUNTIME)
  private @interface SampleModuleOnly {}

  @Provides
  @Singleton
  static A provideA(@SampleModuleOnly B b, @SampleModuleOnly C c){
    return new A(b, c);
  }

  @Provides
  @SampleModuleOnly 
  @Singleton
  static B provideB(){
    return new B();
  }

  @Provides
  @SampleModuleOnly 
  @Singleton
  static C provideC(){
    return new C(); 
  }
}