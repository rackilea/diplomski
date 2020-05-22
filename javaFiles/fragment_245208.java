private String determineSeason(int inputTemp) {
    if (inputTemp > 130 || inputTemp < -20) { 
        throw new IllegalArgumentException("Invalid");
    }

    if (inputTemp >= 90) {
        return "summer";
    } else if (inputTemp >= 70 && inputTemp < 90) {
        return "spring";
    } else { 
        return "winter";
    }
}