// SWIG .i file: an "adapter" function, Java gives you no choice: 
%inline %{
char* my_function(int& err) {
    char * val;
    err = my_function(val);
    return val;
%}