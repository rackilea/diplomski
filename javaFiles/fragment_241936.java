while ((line = reader.readLine()) != null) {
            String[] fields = line.split("[,]");
            if (fields[0].equals(searchID)) {
                fields[12] = "12";
                fields[13] = "21/10/18";
                fields[14] = "2";
            }
            writer.println(String.join(",", fields));
        }