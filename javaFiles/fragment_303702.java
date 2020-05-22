double array[] = new double[100]; // can't assign string to double
                                  // (since you said "30 names", I assume
                                  //  you aren't trying to get numbers from
                                  //  the file)
...
while (value != sentinel) // this performs pointer comparison, whereas you want
                          // string comparison
...
    array[arraySize] = value(); // value is a variable, not a function