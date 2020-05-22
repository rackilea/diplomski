(aStr, bStr) -> {
    int compareResult =
        aStr.substring(aStr.lastIndexOf(' '))
            .compareToIgnoreCase(
                bStr.substring(bStr.lastIndexOf(' '))
            )
    if (compareResult != 0)
        compareResult = aStr.compareToIgnoreCase(bStr);
    return compareResult;
}