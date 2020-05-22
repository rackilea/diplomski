void SetMyStructName(Object* obj, char* newString)
{
    char *b = new char[strlen(newString) + 1]{};
    std::copy(newString, newString + strlen(newString), b);
    obj->mystruct.name = b;
}