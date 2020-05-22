@PostConstuct
public void init() {
    initRules();
    //include another things you want to be initializaed when this page finishes constructing. 
}

private void initRules() {
    ActivityDataSourceDTO dto = getObject();
    if (dto == null)
        return;

    if (_selectedTransformationRule == null)
        _selectedTransformationRule = dto.getTransformationRule();

    if (_selectedCorrelationRule == null)
        _selectedCorrelationRule = dto.getCorrelationRule();
}

//Let the getters do no dto access, so it won't matter if they're called twice on change
public String getSelectedTransformationRule() {
    return _selectedTransformationRule;
}

public String getSelectedCorrelationRule() {
    return _selectedCorrelationRule;
}