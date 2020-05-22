// C/C++ lib: the function you'd like to export but can't:
int my_function(char*& ) { 
    val = new char[20];
    ...put stuff in val, don't forget the terminating \0 char...
    return status;
}