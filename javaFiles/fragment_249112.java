object MyEvent : FXEvent()

class MyView : View() {
    override val root = stackpane {
        paddingAll = 100
        button("Fire!") {
            setOnAction {
                fire(MyEvent)
            }
        }
    }

    val myListener: (MyEvent) -> Unit = {
        alert(Alert.AlertType.INFORMATION, "Event received!", "This message should only appear once.")
        stopListening()
    }

    init {
        subscribe(myListener)
    }

    fun stopListening() = unsubscribe(myListener)

}