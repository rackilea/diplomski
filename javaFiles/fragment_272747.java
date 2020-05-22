private fun makeOperandButton(button: Button, triggerOp: ObjectProperty<Op>) {
    button.onAction = EventHandler {
        curOp = triggerOp.get()
    }
}

private fun makeNumericButton(s: String, button: Button) {
    button.onAction = EventHandler {
        if (curOp == Op.NOOP) {
            value.set(value.get() * 10 + Integer.parseInt(s))
        } else {
            stackValue.set(value.get())
            value.set(java.lang.Double.parseDouble(s))
            stackOp = curOp
            curOp = Op.NOOP
        }
    }
}

private fun makeClearButton(button: Button) {
    button.onAction = EventHandler {
        value.set(0.0)
    }
}