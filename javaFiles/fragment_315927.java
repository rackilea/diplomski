public void setValues(DynamicModel target, int tweenType, float[] newValues) {
    trans = target.model.transform.getTranslation(trans);
    switch (tweenType) {
        ...
        case POSITION_XYZ:
            target.model.transform.setTranslation(newValues[0], newValues[1], newValues[2]);
            break;
        case ROTATION:
            // store the position
            Vector3 position = target.model.transform.getTranslation(new Vector3());
            // then set the rotation and reset the translation
            target.model.transform.setToRotation(Vector3.Y, newValues[0]).setTranslation(position);
            break;
        default:
            assert false;
            break;
    }
}