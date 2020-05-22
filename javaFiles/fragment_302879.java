DllExport void LoadString(char **myStr)
{
    cout << "Before: " << *myStr << endl;
    LoadStringData(myStr);
    cout << "After:" << *myStr << endl;
}