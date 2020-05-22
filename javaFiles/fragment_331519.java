// Check the lower bound, if we have one
if (validFrom && now < validFrom)
{
    return false;
}
// Check the upper bound, if we have one
if (validTo && now > validTo)
{
    return false;
}
return true;