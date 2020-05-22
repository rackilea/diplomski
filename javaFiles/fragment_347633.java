for (int i = 0 ; i < lines.size(); i+=2)
        {
            String question = lines.get(i);
            String answer   = lines.get(i+1);
            String a = JOptionPane.showInputDialog("" + question);
            if (a.equals(answer){
                Thread.sleep(10000);
            }else
                JOptionPane.showMessageDialog(null,"Please look it up");
        }