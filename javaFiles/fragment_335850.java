public void deleteRecursively(Client client, int dir_id) {
        ResultSet res = FileModel.getSubdirs(client, dir_id);

        /if we have some sub folders, we must do recursive call for these folders
        if (res != null) {
            try {
                while (res.next()) {
                    this.deleteRecursively(client, res.getInt("f_id"));
                }
            } catch (Exception e) {
                //....
            }
        }


        ResultSet files = FileModel.findFilesInDir(client, dir_id);

        if (files != null) {
            // deleting files in cur_dir
            while (files.next()) {
               tmp = FileModel.find(client, files.getInt("f_id"));
               if (tmp != null) {
                  tmp.deleteMe(client);
               }
               tmp = null;
            }
         }

        // deleting current_dir
        tmp = FileModel.find(client, dir_id);
        if (tmp != null) {
            tmp.deleteMe(client);
        }

    }