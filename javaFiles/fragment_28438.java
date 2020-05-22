protected boolean isPropertyFilterComparable(
      IPropertyDescriptor propertyDescriptor) {
    return propertyDescriptor instanceof INumberPropertyDescriptor
        || propertyDescriptor instanceof IDatePropertyDescriptor
        || propertyDescriptor instanceof ITimePropertyDescriptor
        || propertyDescriptor instanceof IDurationPropertyDescriptor;
}