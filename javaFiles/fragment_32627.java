try {
    ... 
} catch (DatabaseConnectionException ex) {
    // do something
} catch (DatabaseDataException ex) {
    // do something completely different
} catch (DatabaseTangoException ex) {
    // do something totally extraordinary
}