public void validateTriangle(int sidea, int sideb, int sidec) 
     throws InvalidValueException
 {
    if ((sidea + sideb > sidec) || (sideb + sidec > sidea)
        || (sidea + sidec > sideb))
    {

    } else {
        throw new InvalidValueException;
    }
}