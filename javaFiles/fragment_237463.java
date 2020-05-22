public void encryptPass(String pwd) {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("MD5");
                byte[] passBytes = pwd.getBytes();
                md.reset();
                byte[] digested = md.digest(passBytes);
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < digested.length; i++) {
                    sb.append(Integer.toHexString(0xff & digested[i]));
                }
                encryptedPasscode = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("Error Code: 1002" + e); // Error code for No Algorithm Exception
            }
        }