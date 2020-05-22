public class Employee {
    private State state;

    public Memento save() {
        return new Memento(state);
    }

    public void revert(Memento memento) {
        this.state = memento.state;
    }

    public static class Memento {
        private final State state;

        public Memento(State state) {
            this.state = state;
        }
    }

    public static class State {
        private String name;
        private String phone;
    }
}

public class Caretaker {
    private Stack<Employee.Memento> history;

    public Caretaker() {
        history = new Stack<>();
    }

    public void addMemento(Employee.Memento memento) {
        history.push(memento);
    }

    public Employee.Memento getMemento() {
        return history.pop();
    }
}

public class UndoHandler {
    Employee employee;
    Caretaker caretaker;

    public void snapshot() {
        caretaker.save(employee.save());
    }

    public void undo() {
        employee.revert(caretaker.getMemento());
    }
}