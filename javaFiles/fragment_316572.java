import org.eclipse.swt.widgets.Combo;

/*
 * model - your model object
 * modelAttrName - List<Long> attribute name, within your model
 * toModel, fromModel - update value strategies. can be jsut new UpdateValueStrategy() in 
 * the beginning
*/
public static Binding bindCombo(DataBindingContext bindingContext, Object model, String modelAttrName, UpdateValueStrategy toModel, UpdateValueStrategy fromModel) {

Combo combo = comboViewer.getCombo();

return dataBindingContext.bindValue(WidgetProperties.selection().observe(combo),
    BeansObservables.observeValue(model, modelAttrName), toModel, fromModel);

}