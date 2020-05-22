// If we create an output stream for the Result, we need to close it after the transformation.
    if (_ostream != null) {
        try {
            _ostream.close();
        }
        catch (IOException e) {}
        _ostream = null;
    }