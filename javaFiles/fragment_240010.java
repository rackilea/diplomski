try {
            write = new PrintWriter(new FileWriter(f, true));
              write.println(name);
              write.println(number);
              write.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

    }