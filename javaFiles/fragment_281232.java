int remainingBytes = length;
        while (remainingBytes > 0 && (c = dis.read(buffer, 0, Math.min(buffer.length, remainingBytes))) > 0)
        {
            remainingBytes -= c;
            fos.write(buffer, 0, c);
            // fos.flush(); this is not really necessary
        }