bfqs.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView,
                boolean isChecked) {
              if (imAwake) {
                   if(isChecked==true){
                       String[] command = {"su", "-c", "echo \"" + "1" + "\" > " + FILE};
                         ShellCommand.run(command);
                   }
                    else{
                       String[] command = {"su", "-c", "echo \"" + "0" + "\" > " + FILE};
                     ShellCommand.run(command);
                   }
              }
        }
      });