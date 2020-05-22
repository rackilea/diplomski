byte[] output = new byte[input.length()/2];
        for (int i = 0; i < input.length(); i+=2) {
            String str = input.substring(i, i+2);
            output[i/2] = (byte) Integer.parseInt(str, 16);
        }
        SecretKeySpec keySpec = new SecretKeySpec(output, HMAC_SHA512);