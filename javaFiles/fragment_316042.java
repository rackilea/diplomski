try {
     ...
     throw new MissingRightParenException();
     ...
} catch (MissingRightParenException e) {
     // IllegalStateException extends (IS_A) RuntimeException
     throw new IllegalStateException("This should never happen", e);
}