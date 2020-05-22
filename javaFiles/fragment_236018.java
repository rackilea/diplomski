private void setPropertyState(Object[] propertyStates, String[] propertyNames, String propertyName, Object propertyState) {
    for(int i=0;i<propertyNames.length;i++) {
        if (propertyName.equals(propertyNames[i])) {
            propertyStates[i]=propertyState;
            return;
        }
    }
}