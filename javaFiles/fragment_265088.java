public static void main(String[] args) throws IOException {
              long nanoseconds = 234236402;
              Timestamp ts = new Timestamp(TimeUnit.MILLISECONDS.convert(nanoseconds, TimeUnit.NANOSECONDS));
              SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");
              format.setTimeZone(TimeZone.getTimeZone("UTC"));
              String formatted = format.format(ts);
              System.out.println(formatted);
    }