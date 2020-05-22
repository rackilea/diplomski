public static void main(String[] args) {
    try {

        outerloop: while (true) {
            byte[] lB = new byte[2];

            int startPos = 0;

            while (startPos < lB.length) {

                int ret = System.in.read(lB, startPos,
                        (lB.length - startPos));

                if (ret < 0) {

                    break outerloop;
                }
                startPos += ret;
            }

            int streamLen = System.in.available();

            byte[] rd = new byte[streamLen];

            startPos = 0;

            while (startPos < streamLen) {

                int ret = System.in.read(rd, startPos,
                        (streamLen - startPos));
                if (ret < 0) {

                    break outerloop;
                }
                startPos += ret;
            }

            String inputArgs = new String(rd, "ASCII");

            String[] arguments = inputArgs.split(":");

            String userName = arguments[1];
            String password = arguments[3];
            //
            // Here do the authentication
            //

            boolean resultOfAuthentication = // Result of Authentication;

            byte[] res = new byte[4];
            res[0] = 0;
            res[1] = 2;
            res[2] = 0;

            if (resultOfAuthentication) {
                res[3] = 1;
            } else {
                res[3] = 0;
            }
            System.out.write(res, 0, res.length);
            System.out.flush();
        }
    } catch (Exception e) {
        System.out.println("ERROR");

    }

}