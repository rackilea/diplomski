public static void main(String[] args) {
        String sCurrentLine;
        try (BufferedReader br = new BufferedReader(new FileReader("cars.txt"))) {
            while ((sCurrentLine = br.readLine()) != null) {
                String[] info = sCurrentLine.split(",");
                for (int i = 0; i < 10; i++) {
                    car[i] = new Cars();   //instantiate Cars object or next statement will throw NPE
                    car[i].setPlate(info[0]);
                    car[i].setLocation(Integer.parseInt(info[1]));
                    car[i].setSpeed(Integer.parseInt(info[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }