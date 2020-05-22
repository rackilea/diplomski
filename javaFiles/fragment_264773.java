if (t > 1) {
        hrSize = dec.format(t).concat("TB");
    } else if (g > 1) {
        hrSize = dec.format(g).concat("GB");
    } else if (m > 1) {
        hrSize = dec.format(m).concat("MB");
    } else {
        hrSize = dec.format(size).concat("KB");
    }