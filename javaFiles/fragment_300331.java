while (testScanner.hasNextLine()) {

            String test = testScanner.nextLine();
            if (test.contains("org.junit") || test.contains("org.mockito")) 
            {
                hasTestLines = true;
            }
            count++;
        }

        if (hasTestLines) {
             System.out.println(String.format ("there were %d lines in file %s which also had org.junit||org.mockito", 
                                    count, f.getName());
        }
        else {
             System.out.println(String.format ("there were %d lines in file %s which did NOT have org.junit||org.mockito", 
                                    count, f.getName());
       }