class PollContext(path: String) : ViewModel() {
    val pathProperty = SimpleStringProperty(path)
    var path by pathProperty

    val currentDataProperty = SimpleStringProperty()
    var currentData by currentDataProperty
}