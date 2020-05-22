synchronize(this) {
           String[] log = new String[3];

           log[0] = id;
           log[1] = user;
           log[2] = new Timestamp(System.currentTimeMillis());

           writer.writeNext(log);
           writer.flushQuietly();
        }