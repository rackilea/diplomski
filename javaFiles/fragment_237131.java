public String add(BigInteger other) {
            byte[] digits1, digits2;
            if (this.digits.length >= other.digits.length) {
                digits1 = this.digits;
                digits2 = other.digits; 
            } else {
                digits1 = other.digits;
                digits2 = this.digits;
            }
            int remainder = 0;
            int s1 = digits1.length - 1; 
            int s2 = digits2.length - 1; 
            byte[] resultDigits = new byte[s1 + 2];

            for (int i = s1; i >= 0; i--) {
                int diff = digits1.length - digits2.length;
                int digit1 = digits1[i] - 48;
                int digit2 = i < diff ? 0 : digits2[i - diff] - 48;
                int r = digit1 + digit2 + remainder; 
                remainder = r > 9 ? 1 : 0;
                resultDigits[i+1] = (byte)(r % 10 + 48);
            }
            resultDigits[0] += (byte) remainder + 48;
            String result = resultDigits[0] == 48 ? new String(resultDigits).substring(1) : new String(resultDigits);
            return result;
        }