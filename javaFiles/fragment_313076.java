ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "C:\\Python27\\python.exe C:\\Users\\Bens\\Desktop\\test.py");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    } catch (IOException ex) {
        Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
    }