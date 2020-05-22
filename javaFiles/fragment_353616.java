boolean valid = false;

for (Object availableItem : availableItems) {
    if (selectedItem.equals(availableItem)) {
        valid = true;
        break;
    }
}

if (!valid) {
    // Validation error: Value is not valid!
}