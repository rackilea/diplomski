while (true) {
        keyValue = System.in.read();
        if (keyValue == 'x') {
            System.out.println(number);
            break;
        }
        keyValue = keyValue - '0';
        number = number * 10 + keyValue;
        System.out.println(number);
    }