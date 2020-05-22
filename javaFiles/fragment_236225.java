class ProxySpinnerModel implements SpinnerModel {
    getValue() { return originalSpinner.getValue() - 10 }
    setValue(v) { originalSpinner.setValue(v+10) }
}

spinnerA = new JSpinner()
spinnerB = new JSpinner( new ProxySpinnerModel( spinnerA.getModel() ) )