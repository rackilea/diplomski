FileReader file = new FileReader("client-temp.txt");
try (BufferedReader tc = new BufferedReader(file)) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("datastore.txt"))) {

        String line;

        while ((line = tc.readLine()) != null)
        {
            String[] data = line.split(",");
            String sensortype = data[0];
            String date = data[1];
            String time = data[2];
            String reading = data[3];

            String newdata = sensortype + date + time + reading;
            System.out.println(line);

            if (line != null)
            {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Data sent to file");
        }
    } catch (IOException exp) {
        exp.printStackTrace();
    }
} catch (IOException exp) {
    exp.printStackTrace();
}