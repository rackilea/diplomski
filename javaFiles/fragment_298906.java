LongHolder written = new LongHolder();

while (true) {
    exchangeStream64.Read(data, READ_AMOUNT, dataAmount);
    if (0 == dataAmount.value) {
        break;
    }

    jos.write(data.value, (int)dataAmount.value, (int)written.value);
}