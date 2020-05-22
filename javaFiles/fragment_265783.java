try (Scanner sc = new Scanner(new FileInputStream(verbsFile));){

                ArrayList<String> lines = new ArrayList<String>();
                String line;
                while ((line = sc.nextLine()) != null) {
                    lines.add(line);
                }
                Random rd = new Random();
                int i = rd.nextInt(lines.size());
                String verb = lines.get(i); // this is a random verb from the verbsFile

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }