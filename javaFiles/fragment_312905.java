public class ToDo {

    private StringProperty task = new SimpleStringProperty();
    public StringProperty taskProperty() {return task;}

    private ObjectProperty<Importance> importance = new SimpleObjectProperty<Importance>();
    public ObjectProperty<Importance> importanceProperty() {return importance;}

    public ToDo(String task, Importance importance){
        this.task.set(task);
        this.importance.set(importance);
    }


    enum Importance {
        DONTCARE, SHALL, MUST, FIRSTPRIO;

          @Override
          public String toString() {
            switch(this) {
              case DONTCARE: return "I don't care";
              case SHALL: return "It shall be done";
              case MUST: return "It must be done";
              case FIRSTPRIO: return "I will die if I do not do it";
              default: throw new IllegalArgumentException();
            }
          }
    }

}