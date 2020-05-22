IObservableValue targetOV = WidgetProperties.text(SWT.Modify).observe(text control);

IObservableValue modelOV = PojoProperties.value("your field").observe(object); 

bindContext.bindValue(targetOV, modelOV);

modelOV.addChangeListener(change listener);