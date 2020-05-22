92  -  intBuffer.position(intBuffer.position()+n).flip();
93  -  for (;intBuffer.remaining()>3 && i<a.length;i++){//need at least 4 bytes to form an int
94  -      a[i] = intBuffer.getInt();
93  +  longBuffer.position(longBuffer.position()+n).flip();
94  +  for (;longBuffer.remaining()>7 && i<a.length;i++){//need at least 4 bytes to form an int
95  +      a[i] = longBuffer.getLong();