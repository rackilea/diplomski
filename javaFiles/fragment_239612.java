public static Long getUidRxBytes(int uid) {
        BufferedReader reader;
        Long rxBytes = 0L;
        try {
            reader = new BufferedReader(new FileReader("/proc/uid_stat/" + uid
                    + "/tcp_rcv"));
            rxBytes = Long.parseLong(reader.readLine());
            reader.close();
        }
        catch (FileNotFoundException e) {
            rxBytes = TrafficStats.getUidRxBytes(uid);
            //e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return rxBytes;
    }**