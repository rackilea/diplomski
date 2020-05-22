package de.scrum_master.app;

public class ThrottlingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ThrottlingException(String arg0) {
        super(arg0);
    }
}