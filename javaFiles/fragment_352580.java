private final StringProperty project = new SimpleStringProperty();

public final StringProperty projectProperty() {
   return project;
}

public final String getProject() {
   return project.get();
}

public final void setProject(String value) {
    project.set(value);
}