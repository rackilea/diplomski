private char A, B, C, D;

public char getClassification() {
    if(parts[0] >= 0 && parts[0] <= 127)
        return (A);
    else if(parts[0] >= 128 && parts[0] <= 191)
        return (B);
    else if(parts[0] >= 192 && parts[0] <= 223)
        return (C);
    else if(parts[0] >= 224 && parts[0] <= 255)
        return (D);
    else
       return //Something Else(char Value)
}