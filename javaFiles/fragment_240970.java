BufferedReader br = new BufferedReader(new FileReader(pathFile));

            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.contains(lookingForMe))
                    found = true;
            }