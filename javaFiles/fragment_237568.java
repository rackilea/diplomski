try {
        byte[] u = new byte[]{(byte) 0xC3, (byte) 0xA0};

        SortedMap m = Charset.availableCharsets();
        Set k = m.keySet();
        Iterator i = k.iterator();
        String encoding = "";
        while (i.hasNext()) {
            String e = (String) i.next();
            byte[] cp = new String(u, "UTF-8").getBytes(e);
            if (cp[0] == (byte) 0xB5)
            {
                encoding = e;
                break;
            }
        }
        System.out.println(encoding);
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }