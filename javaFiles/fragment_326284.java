c++;
            if(c>=ActionTime.size()){
                timer.stop();
                JOptionPane.showMessageDialog(null, "Workout Completed!");
                return; //add this too as the program should not continue with below
            }
            Action.setText(ActionName.get(c)); //to here