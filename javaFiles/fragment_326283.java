c++;
            Action.setText(ActionName.get(c)); //move this down
            if(c>=ActionTime.size()){
                timer.stop();
                JOptionPane.showMessageDialog(null, "Workout Completed!");
            }