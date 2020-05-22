// отправка пакета с файлами
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), ENCODING));
            String messageType = br.readLine();
            switch(messageType) {
            case "connect": {
                List<String> results = new ArrayList<String>();

                File[] files = new File("C:/Tenzor_Denis/ServerFiles/").listFiles();
                //If this pathname does not denote a directory, then listFiles() returns null. 

                for (File file : files) {
                    if (file.toString().endsWith(".txt")) {
                        results.add(file.getName());
                    }
                }

                try {
                    for(int i = 0; i < results.size(); i++) {
                        bw.write(results.get(i));
                        bw.newLine();
                        //textArea.append(" " + results.get(i));
                    }
                    textArea.append("\nClient sends a command: " + messageType);

                } catch(Exception e) {
                    e.printStackTrace();
                }
                bw.close();
                br.close();
            }
            break;
            }
        }