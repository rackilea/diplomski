URL url = new URL("http://mineverse.pl/haslicense.php?license=" + license);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String str = null;
        boolean ret = false;
        while ((str = in.readLine()) != null) {
            str = str.toLowerCase();
            if (str.contains("true")) {
                ret = true;
                break;
            }
        }
        in.close();
        return ret;