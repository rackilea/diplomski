int balance = Integer.parseInt(tvBalanceBIP .getText().toString()) * 100;
    int total = 65535;
    int diference = total - balance;

    byte[] balanceBytes = ByteBuffer.allocate(4).putInt(balance).array();
    balanceBytes[0] = (byte)0x00;
    balanceBytes[1] = (byte)0x00;

    byte[] diferenceBytes = ByteBuffer.allocate(4).putInt(diference).array();
    diferenceBytes[0] = (byte)0xFF;
    diferenceBytes[1] = (byte)0xFF;

    DATA_CARGA = new byte[] {
            balanceBytes[3], balanceBytes[2], balanceBytes[1], balanceBytes[0],
            diferenceBytes[3], diferenceBytes[2], diferenceBytes[1], diferenceBytes[0],
            balanceBytes[3], balanceBytes[2], balanceBytes[1], balanceBytes[0],
            (byte)0x00, (byte)0x02, (byte)0x01, (byte)0x86
    };
    tvSaldoBIP.setText(DATA_CARGA.toString());