// in your class member declarations:
char hidden[] = createHidden();

// possible implementation of createHidden:
char[] createHidden()
{
    if (original != null)
        return new char[original.length()];
    else return null;
}