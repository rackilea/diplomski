List<Auto> autos = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("Test.txt"))) {
            String line = null;
            while((line = in.readLine()) != null) {
                String[] values = line.split(",");
                autos.add(new Auto(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        Double.parseDouble(values[3]),
                        values[4]));
            }
        }