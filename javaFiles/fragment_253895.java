for (i = 0; i < names.length; i++) {
    if (inName.equals(names[i])) {
        System.out.println("Data found at [" + i + "]");
        break;
    }
}

// If the value stored in `inName` is found, the value of `i` will not reach up
// to the value equal to `names.length` because of the `break` statement. If the
// value of `i` has reached there, it means that the value stored in `inName`
// has not been found.
if (i == names.length) {
    System.out.println("Data not found!");
}