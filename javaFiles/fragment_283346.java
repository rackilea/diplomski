EventQueue.invokeLater(new Runnable() {

            public void run() {
               //put  your swing operation here
            }
        });



EventQueue.invokeLater(new Runnable() {

                        public void run() {
                            int selection = JOptionPane.showOptionDialog(frame,
                                    "Do you want to download \"" + file + "\"?",
                                    "Download", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, null,
                                    JOptionPane.YES_OPTION);
                            if (selection == JOptionPane.YES_OPTION) {
                                JFileChooser jFileChooser = new JFileChooser();
                                jFileChooser
                                        .setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                                int rValue = jFileChooser.showDialog(frame, "Öffnen");

                                if (rValue == JFileChooser.APPROVE_OPTION) {
                                    new ObjectOutputStream(socket.getOutputStream())
                                            .writeObject("file_confirm=" + file);

                                    String selectedDir = jFileChooser.getSelectedFile()
                                            .getAbsolutePath();

                                    OutputStream out = new FileOutputStream(new File(
                                            selectedDir, file));

                                    try {

                                        byte[] buffer = new byte[1024];

                                        for (int c = 0; (c = socket.getInputStream()
                                                .read(buffer)) > 0;) {
                                            out.write(buffer, 0, c);
                                            System.out.println(c);
                                        }

                                        System.out.println("test1");

                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    } finally {
                                        System.out.println("test2");
                                        out.flush();
                                        out.close();
                                        System.out.println("test3");
                                    }
                                }
                            }//  
                        }
                    });