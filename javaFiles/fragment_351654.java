if (notches < 0) {
        System.out.println("Mouse wheel moved UP " + -notches + " notch(es)");
        slider.setValue(slider.getValue() + 1);
    } else
    if (notches > 0) {
        System.out.println("Mouse wheel moved DOWN " + notches + " notch(es)");
        slider.setValue(slider.getValue() - 1);
    }