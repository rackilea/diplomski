public void setDriveMotorPower(Double power1, Double power2) {
    motorLeft.setPower(power1);
    if (power2 == null) {
        motorRight.setPower(power1);
    } else {
        motorRight.setPower(power2);
    }
}