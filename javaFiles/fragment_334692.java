if (event.getSource() == stopBtn)
        {
             stopBtn.setEnabled(false);
             startBtn.setEnabled(true);
        }

         if (event.getSource() == startBtn)
         {
             stopBtn.setEnabled(true);
             startBtn.setEnabled(false);
        }