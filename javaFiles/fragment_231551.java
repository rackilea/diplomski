int sign = +1, result = 0;
for (String arg : args) {
    switch (arg) {
        case "+":
            sign = +1;
            break;
        case "-":
            sign = -1;
            break;
        default:
            result += sign * Integer.parseInt(arg);
    }
}