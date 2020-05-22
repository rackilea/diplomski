for( String option : options ){
           OptionEntity tmp_option = new OptionEntity();
           tmp_option.setText( option );
           ops.add(tmp_option);
           tmp_option.setSurvey(survey);
       }