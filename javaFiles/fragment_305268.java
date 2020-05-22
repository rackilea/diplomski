PersonRegistry registry = ...
viewer.setContentProvider( new PersonContentProvider() );
viewer.setInput( registry );

class PersonContentProvider implements IStructuredContentProvider {
  PersonRegistry registry;
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    this.registry = ( PersonRegistry )newInput;
  }

  public Object[] getElements(Object inputElement) {
    return registry.getPersons();
  }

  ...
}