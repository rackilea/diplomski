List<String> a = new ArrayList<String>();
            String hospital = null;

            while (results.next()) 
            {
                // Put into interactive list    
                hospital = results.getString("hospitalName"); 
                {
                    // Loops each hospital via popup, needs to be added to a selection menu
                    //JOptionPane.showMessageDialog(null, hospital, "Hospital List", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(hospital);
                a.add(hospital);
                }
            }

            {
                // Add the hospital to the array of hospitals found
                Object[] options = a.toArray();

                // Give operator the choice of hospital suited for the patient             
                JOptionPane.showInputDialog(null, "Please choose a hospital", "Determined Hospitals", 
                         JOptionPane.QUESTION_MESSAGE,  null, options, options[0]);