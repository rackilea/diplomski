@ApplicationException(rollback = true)
public class DatabaseException extends Exception {
// omited
}

@ApplicationException(rollback = true)
public class CouldNotMoveException extends Exception {
// omited
}