public void start()
{
    while (!errflag) {
        try {
            Ftp ftp = new Ftp();
            String res = ftp.execute("hi").get();
            if (res.equals("Finished"))
                break;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}