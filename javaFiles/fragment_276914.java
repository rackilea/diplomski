contributor(context()) {
  if (classType?.fields?.find {it.hasAnnotation("groovy.beans.Bindable")}) {
    method name: "addPropertyChangeListener", type: "void", params: [s: "java.lang.String", l: "java.beans.PropertyChangeListener"]
    method name: "addPropertyChangeListener", type: "void", params: [l: "java.beans.PropertyChangeListener"]

    method name: "removePropertyChangeListener", type: "void", params: [s: "java.lang.String", l: "java.beans.PropertyChangeListener"]
    method name: "removePropertyChangeListener", type: "void", params: [l: "java.beans.PropertyChangeListener"]

    method name: "firePropertyChange", type: "void", params: [s: "java.lang.String", o1: "java.lang.Object", o2: "java.lang.Object"]

    method name: "getPropertyChangeListeners", type: "java.beans.PropertyChangeListener[]"
    method name: "getPropertyChangeListeners", type: "java.beans.PropertyChangeListener[]", params: [s: "java.lang.String"]
  }
}