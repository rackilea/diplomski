interface Command { /* execute / undo etc */ }

public class AddFriendCommand implements Command {
    private String friendName;

    // ... other fields, constructor / getters etc ...

    public void execute() {
        // Actually do it...
        System.out.println("Added friend " + name);
    }

    public void undo() {
        // Undo it...
        System.out.println("Removed friend " + name);
    }
}

public class RemoveFriendCommand implements Command {
    private String friendName;

    // ... other fields, constructor / getters etc ...

    public void execute() {
        // Actually do it, maybe throw exception if friend does not exist?
        // (that would have to be a runtime exception unless you want the interface's method to throw stuff);
        System.out.println("Removed friend " + name);
    }

    public void undo() {
        // Undo it...
        System.out.println("Added friend " + name);
    }
}