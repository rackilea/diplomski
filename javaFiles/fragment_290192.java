// General way
private class ProductObserver implements IObserver<Product> { }

private ProductObserver productObserver;

// Aspect oriented way
private class LoggerObserver<T> implements IObserver<T> { }

private LoggerObserver<Product> loggerObserver;