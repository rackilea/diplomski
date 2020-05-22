boolean prime = true;
    for (int i = 2; i < no; i = i + 1) {
        if (no % i == 0) {
            jTextArea1.setText("No. is not prime");
            prime = false;
            break;  // once we have found a divisor, we can stop looking
        }
    }
    if (prime) {
        jTextArea1.setText("No is prime")
    }