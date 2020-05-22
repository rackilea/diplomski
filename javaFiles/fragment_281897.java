@Suppress("unused")
    @Module
    abstract class ViewModelModule {
        @Binds
        @IntoMap
        @ViewModelKey(MyViewModel::class)
        abstract fun bindsMyViewModel(viewModel: MyViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}