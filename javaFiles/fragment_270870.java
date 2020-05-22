public void setNumControlPoints(int num) {
    while (num < _scale.sizeOfCfvoArray()) {
        _scale.removeCfvo(_scale.sizeOfCfvoArray()-1);
        _scale.removeColor(_scale.sizeOfColorArray()-1);
    }
    while (num > _scale.sizeOfCfvoArray()) {
        _scale.addNewCfvo();
        _scale.addNewColor();
    }
}