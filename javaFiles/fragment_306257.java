try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec("{EXTERNAL_JAR_EXECUTE_COMMAND}");

                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

                String line=null;

                while((line=input.readLine()) != null) {
                    System.out.println(line);
                }

                int exitVal = pr.waitFor();

            } catch(Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }