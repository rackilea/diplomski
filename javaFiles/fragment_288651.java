String folderPath = "/Android/data/Myfolder";
        String fileName = "music.mp3";
        File music = new File(folderPath+"/"+fileName);
        if(music.exists()){ // return true if found
            System.out.println(fileName +"found");
            // other found logics here
        }

        else {
            System.out.println(fileName +" not found here");
            // other not found logics here
        }