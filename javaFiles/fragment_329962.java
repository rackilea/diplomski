set counter to 0
Repeat i till end of array{
    Repeat j till end of array{
        check if array[j] == array[i]{
            increment the counter
        }
    }
    check if counter<2{
        break;
    }
}
check if counter<2{
    return false;
}
else{
    return true;
}