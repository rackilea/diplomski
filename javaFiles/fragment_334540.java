else if (SQL_error.getErrorCode() == 04088F) 
                    {
                        System.out.println("" + (String.valueOf(SQL_error.getErrorCode() == 04088F)));
                        JOptionPane.showMessageDialog(null, "Error during execution of trigger. Contact administrator. The data logic is faulty. Please recheck logic.", "Error Message", JOptionPane.ERROR_MESSAGE);
                        //System.out.println("The data logic is faulty. Please recheck logic.");
                    }