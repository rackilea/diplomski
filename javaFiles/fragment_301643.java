try{
        FileOutputStream fos = openFileOutput(mealFile, MODE_APPEND);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        for(int i=0; i<temp_name.size(); i++){
            if(!(temp_name.get(i).equals(mealName.getText().toString()))){
                osw.append(temp_name.get(i) + "\t");
                osw.append(temp_meals.get(i) + "\t");
                osw.append(temp_scale.get(i) + "\t");
                System.getProperty("line.separator");
                osw.flush();
            }
        }
        osw.close();
    }catch(Exception e){
        updateWarningMessage(6);
    }