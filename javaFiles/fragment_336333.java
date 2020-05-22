if (whippedCream && chocolate) { // both true
    return "both selected";
} else if (whippedCream) { // only whippedCream is true
    return "whippedcream";
} else if (chocolate) { // only chocolate is true
    return "chocolate";
} else {
    return "none checked";
}