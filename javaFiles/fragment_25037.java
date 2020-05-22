@Binds
@IntoMap
@ViewModelKey(MedicationsViewModel.class) // no scope here!
abstract ViewModel bindMedicationsViewModel(MedicationsViewModel viewModel);

// neither here!
class MedicationsViewModel @Inject constructor()