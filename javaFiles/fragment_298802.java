public static char gradeFor(final float tot, final float sum) {
    float ratio = tot / sum;

    if(ratio >= 0.9f) {
        return 'A';
    }

    if(ratio >= 0.8f) {
        return 'B';
    }

    if(ratio >= 0.7f) {
        return 'C';
    }

    if(ratio >= 0.6f) {
        return 'D';
    }

    if(ratio >= 0.5f) {
        return 'E';
    }

    return 'F';
}