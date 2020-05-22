for (int i = 0; i < triangleHeight; i++) { //Top downwards

    for (int h = 0; h < horizontalRepeats; h++) {
        for (indentWidth = 0; indentWidth < triangleHeight * 0 + i; indentWidth++) {
            System.out.print(indentChar);
        }

        for (fillWidth = 0; fillWidth < (triangleBaseLength - i * 2); fillWidth++) {
            System.out.print(fillChar);
        }

        // Repeat the first for loop...
        for (indentWidth = 0; indentWidth < triangleHeight * 0 + i; indentWidth++) {
            System.out.print(indentChar);
        }
    }

    System.out.println();
}