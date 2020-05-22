int value = VALUE_TO_CHECK | OTHER_VALUE_TO_CHECK;

if ((value & VALUE_TO_CHECK) == VALUE_TO_CHECK)
{
    // do something--it was set
}

if ((value & OTHER_VALUE_TO_CHECK) == OTHER_VALUE_TO_CHECK)
{
    // also set (if it gets in here, then it was defined in 
    //   value, but it does not guarantee that it was set with
    //   OR without other values. To guarantee it's only this
    //   value just use == without bitwise logic)
}