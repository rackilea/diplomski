String[] sections= {"[section_name_1]","[section_name_2]","[section_name_3]","[section_name_4]"};
        String textFromFile = "Text first [section_name_1] Text with values pattern1 [section_name_2] Text with values pattern2";
        int count = 0;
        for(int i = 0; i < sections.length; i++){
            if(textFromFile.contains(sections[i])){//Use this to tell how big the parms array will be.
                count++;
            }
            sections[i] = sections[i].replace("[", "\\[").replace("]", "\\]");//Removes the brackets from being delimiters.
        }
        String[] parms = new String[count+1];//Where the split items will go.
        int next = 0;//The next index for the parms array.
        for(String sec : sections){
            String split[] = textFromFile.split(sec);//Split the file's text by the sec
            if(split.length == 2){
                parms[next] = split[0];//Adds split to the parms
                next++;//Go to the next index for the parms.
                textFromFile = split[1];//Remove text which has just been added to the parms.
            }
        }
        parms[next] = textFromFile;//Add any text after the last split.
        for(String out : parms){
            System.out.println(out);//Output parms.
        }