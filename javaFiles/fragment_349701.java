interface ValidationBehavior {

    companion object {
        inline operator fun invoke(fn: () -> Unit) = object: ValidationBehavior {
            override fun onValidated() = fn()
        }
    }

    fun onValidated()
}

private fun getBehavior(payloadBehavior: String) : ValidationBehavior {
    when(BehaviorEnum.valueOf(payloadBehavior)) {
        BehaviorEnum.IDLE -> return ValidationBehavior { /* do stuff */ }
    }
}