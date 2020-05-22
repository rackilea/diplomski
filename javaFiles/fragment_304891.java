protected PropertyNode(int fcStart, int fcEnd, Object buf)
{
    _cpStart = fcStart;
    _cpEnd = fcEnd;
    _buf = buf;

    if(_cpStart < 0) {
        _logger.log(POILogger.WARN, "A property claimed to start before zero, at " + _cpStart + "! Resetting it to zero, and hoping for the best");
      _cpStart = 0;
    }
    //more code