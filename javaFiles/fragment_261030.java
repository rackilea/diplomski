sealed class RecoverableActions {
    abstract val actionName: String

    abstract val undoActionName: String

    abstract fun run()

    object CreateAction : RecoverableActions() {
        override fun run() {
            //do create
        }
        override val actionName = CreateAction::class.java.simpleName
        override val undoActionName = DeleteAction::class.java.simpleName
    }

    object DeleteAction : RecoverableActions() {
        override fun run() {
            //do create
        }
        override val actionName = DeleteAction::class.java.simpleName
        override val undoActionName = CreateAction::class.java.simpleName
    }

    object CopyAction : RecoverableActions() {
        override fun run() {
            //do create
        }
        override val actionName = CopyAction::class.java.simpleName
        override val undoActionName = CopyAction::class.java.simpleName // ?
    }
}