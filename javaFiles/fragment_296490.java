Runtime rt = Runtime.getRuntime();
                try {
                    rt.exec("cmd.exe /c cd /d d: & start cmd.exe /k javac Maq.java");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }