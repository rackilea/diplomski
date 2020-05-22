// replace
if (replace(key, oldValue, newValue)) {
    // replaced as expected.
    return newValue;
}

// some other value replaced old value. try again.
oldValue = get(key);