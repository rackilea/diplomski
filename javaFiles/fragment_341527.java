public void run() {
    try (BufferedReader inStream = new BufferedReader(
        new InputStreamReader(socket.getInputStream()))){

        String data = inStream.readLine();
        while(data != null) {
            if(data.equals("stop"))
                break;
            broadcast(data);
            data = inStream.readLine();
        }
    }
    catch(Exception e){
        System.out.println("Run exception "+e);
    } finally {
        al.remove(socket); //This is important to do
    }

}