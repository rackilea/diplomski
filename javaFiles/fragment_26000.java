File logFile = new File(basePath, "gamelog.txt");
            FileWriter ofs = new FileWriter(logFile);
            BufferedWriter outStream = new BufferedWriter(ofs);
            for (int i=0; i < bustOutLog.size(); i++) {
                Log.d(TAG, "onClick: writing " + bustOutLog.get(i));
                outStream.write(bustOutLog.get(i));
                outStream.write(String.format("\n"));
            }
            outStream.close();
            ofs.close();