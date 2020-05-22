if (Grosspay[i] > 0.00 || Grosspay[i] < 999.99) {
        incomeTax[i] = (8 / 100.0) * Grosspay[i];
    } else if (Grosspay[i] > 500.00 || Grosspay[i] < 999.99) {
        incomeTax[i] = (10 / 100.0) * Grosspay[i];
    } else if (Grosspay[i] > 1000.00) {
        incomeTax[i] = (15 / 100.0) * Grosspay[i];
    }