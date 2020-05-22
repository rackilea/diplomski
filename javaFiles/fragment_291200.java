Vector ls = channelSftp.ls(path);
        Pattern pattern = Pattern.compile("xyz_[0-9]{8}.csv.gz");
        for (Object entry : ls) {
            ChannelSftp.LsEntry e = (ChannelSftp.LsEntry) entry;
            //match regex on e.getFilename()
            Matcher m = pattern.matcher(e.getFilename());
            if (m.matches()) {
                //TODO you code
            }

        }