String previous = ""; // empty string: guaranteed to be less than or equal to any other

for (final String current: thelist) {
    if (current.compareTo(previous) < 0)
        return false;
    previous = current;
}

return true;