if(Boolean)                                                 \
    something(); <- one statement                           |
else                                                        | one
{                                                           | if
    if(Boolean)                              \              | statement
        something(); <- one statement        | one if       |
    else                                     | statement    |
        something(); <- one statement        /              |
}                                                           /