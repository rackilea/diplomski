public static Long getUidTxBytes(int uid) {
        BufferedReader reader;
        Long txBytes = 0L;
        try {
            reader = new BufferedReader(new FileReader("/proc/uid_stat/" + uid
                    + "/tcp_snd"));
            txBytes = Long.parseLong(reader.readLine());
            reader.close();
        }
        catch (FileNotFoundException e) {
            txBytes = TrafficStats.getUidTxBytes(uid);
            //e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return txBytes;
    }