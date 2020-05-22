byte bytesBefore[] = {-1,-2,65,76,79,80};
        try {
            String str = new String(bytesBefore);
            byte bytesAfter[] = str.getBytes();
            System.out.println("str is " + str);
            System.out.println("after");
            for(Byte b : bytesAfter){
                System.out.print(" " + b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }