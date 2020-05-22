/**
 * NO_APPLICABLE_SEVERITY occurs only when the system was
 * unable to determine the severity.
 */
public static final int NO_APPLICABLE_SEVERITY = 0;
/**
 * WARNING_SEVERITY is associated with SQLWarnings.
 */
public static final int WARNING_SEVERITY = 10000;
/**
 * STATEMENT_SEVERITY is associated with errors which
 * cause only the current statement to be aborted.
 */
public static final int STATEMENT_SEVERITY = 20000;
/**
 * TRANSACTION_SEVERITY is associated with those errors which
 * cause the current transaction to be aborted.
 */
public static final int TRANSACTION_SEVERITY = 30000;
/**
 * SESSION_SEVERITY is associated with errors which
 * cause the current connection to be closed.
 */
public static final int SESSION_SEVERITY = 40000;
/**
 * DATABASE_SEVERITY is associated with errors which
 * cause the current database to be closed.
 */
public static final int DATABASE_SEVERITY = 45000;
/**
 * SYSTEM_SEVERITY is associated with internal errors which
 * cause the system to shut down.
 */
public static final int SYSTEM_SEVERITY = 50000;