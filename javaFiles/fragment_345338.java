private void calculate() {

    double b = Double.parseDouble(berat.getText().toString());

    if (b <= 0.5) {
        totalPrice1 = 7;
        serviceFee1 = totalPrice1 * 0.2;
        carierFee1 = totalPrice1 * 0.8;
    } else {
        totalPrice1 = b * 12.9;
        serviceFee1 = totalPrice1 * 0.2;
        carierFee1 = totalPrice1 * 0.8;
    }
    serviceFee1 = Math.round(serviceFee1 * 100.0) / 100.0;
    carierFee1 = Math.round(carierFee1 * 100.0) / 100.0;
}