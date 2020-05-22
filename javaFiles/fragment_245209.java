class Seasons {

    public static void main(String[] args) {
        String response = JOptionPane.showInputDialog(null, "Enter the temperature");
        int inputTemp = Integer.parseInt(response);
        try {
            String message = String.format("Based on the temperature of %d, it is most likely %s", inputTemp, determineSeason(inputTemp));
            JOptionPane.showMessageDialog(null, message);
        } catch (IllegalTemperatureValueException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static String determineSeason(int inputTemp) throws IllegalTemperatureValueException {
        if (inputTemp > 130 || inputTemp < -20) {
            throw new IllegalTemperatureValueException("incorrect temperature value");
        }

        return inputTemp >= 90 ? "summer" : (inputTemp >= 70 ? "spring" : "winter");
    }
}

class IllegalTemperatureValueException extends Exception {
    public IllegalTemperatureValueException(String message) {
        super(message);
    }
}