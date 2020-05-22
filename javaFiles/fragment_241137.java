private ${Type} ${property};

public ${Type} get${Property}() {
    return ${property};
}

public void set${Property}(${Type} ${property}) {
    ${propertyChangeSupport}.firePropertyChange("${property}", this.${property}, this.${property} = ${property});
}