class MyView : View() {
    override val root = stackpane {
        paddingAll = 100
        button("Fire!") {
            setOnAction {
                fire(MyEvent)
            }
        }
    }

    init {
         subscribe<MyEvent>(times = 1) {
            alert(Alert.AlertType.INFORMATION, "Event received!", "This message should only appear once.")
        }
    }

}