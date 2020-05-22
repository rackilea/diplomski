StringBuilder resultKamera2 = new StringBuilder();

            {
            try  {
                BufferedReader brKamera2 = new BufferedReader(new FileReader("D:/test1.txt")
                while ((lineKamera2 = brKamera2.readLine()) != null) {

                Matcher categoryMatcherKamera2 = CategorieKamera2.matcher(lineKamera2);                   
                Matcher itemMatcherKamera2 = CategorieSiCantitateKamera2.matcher(lineKamera2);