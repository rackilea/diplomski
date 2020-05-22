try {
    Float value = Float.valueOf(text);

    if (value == null || value == 0f) {
        answer.setText("Zero");
    }
} catch (NumberFormatException e) {
    answer.setText("Invalid input");
}