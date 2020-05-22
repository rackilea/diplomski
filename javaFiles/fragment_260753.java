if (num1 == 0 || num2 == 0) {
        return 0;
}

else if( num2 < 0 ) {
    return - num1 + multiply2(num1, num2 + 1);
}

else {
    return num1 + multiply2(num1, num2 - 1);
}