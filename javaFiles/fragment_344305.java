String file_names[]= new String[(int)Math.max(sizeOfFiles,1)];
        if (sizeOfFiles < 1) {
            file_names[0] = "No recent files.\nTouch New to add files.";
        } else  { 
            for(int i=sizeOfFiles-1;i>=0;i--){
                file_names[(sizeOfFiles-1)-i] = filesList[i].getName();
            }
        }  
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.file_list, file_names);
        listView.setAdapter(adapter);