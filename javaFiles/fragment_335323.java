class Binding(val listener: Listener) : DataBindingComponent {
    override fun getBinding(): Binding {
        return this
    }
    // all the other stuff
}