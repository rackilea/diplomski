final Process p = new ProcessBuilder("cat", "/etc/hosts").start();
    final BufferedReader br = new BufferedReader(new InputStreamReader(
            p.getInputStream()));

    final Runnable r = new Runnable() {
        @Override
        public void run() {
            try {
                try {
                    for (String line = br.readLine(); line != null; line = br
                            .readLine()) {
                        final String l = line;
                        System.out.println(l);
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                textArea.setText(textArea.getText() + "\n" + l);
                            }
                        });

                        Thread.sleep(50);
                    }
                } finally {
                    br.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    final Thread t = new Thread(r);
    t.start();