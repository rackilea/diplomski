while (true) {
            byteArray = new byte[1024]; // I ADDED THIS AND NOW THE JAVA SERVER RECEIVES IT CORRECTLY!

            c = is.read(byteArray, 0, byteArray.length);
            recv = new String(byteArray, 0, c);


            System.out.println(recv);
            if (recv.equals("<EOF>")){
                break;
            }
            list.add(recv);
        }