public static void main(String[] args) {
    String machine = "utcnist2.colorado.edu";
    // standart port on Computer to take time of day on normal computer
    final int daytimeport = 13;

    Socket socket = null;
    try {
        socket = new Socket(machine, daytimeport);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        reader.readLine();
        String time = reader.readLine();
        System.out.printf("%s says it is %s %n", machine, time);
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}