@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (SplashActivityModule::class)])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(kotlinApplication: KotlinApplication)
}