PEMReader in = new PEMReader(reader, dlg);
        Object obj = in.readObject();
        if (obj == null) {
            // Some PEM files have garbarge at the top
            for (int i = 0; i < 9 && obj == null; ++i) {
                obj = in.readObject();
            }
        }
        keys = null;
        if (obj instanceof KeyPair) {
            keys = (KeyPair)obj;
            obj = in.readObject();
        }
        List<X509Certificate> list = new ArrayList<X509Certificate>();
        while (obj != null) {
            if (obj instanceof X509Certificate) {
                list.add((X509Certificate)obj);
            }
            obj = in.readObject();
        }