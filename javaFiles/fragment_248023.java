public void setLength(int newLength) {
    if (newLength <= MIN) 
        length = MIN;
    else if(newLength >= MAX)
        length = MAX;
    else
        length = newLength;
}

public void setWidth(int newWidth) {
    if (newWidth <= MIN) 
        width = MIN;
    else if(newWidth >= MAX)
        width = MAX;
    else
        width = newWidth;
}