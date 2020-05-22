for (int i = 0; i <= numberOfThisDisk; i++) {
                if (i == numberOfThisDisk) {
                    retList.add(zipModel.getZipFile());
                } else {
                    String fileExt = ".z0";
                    if (i > 9) {
                        fileExt = ".z";
                    }
                    partFile = (zipFileName.indexOf(".") >= 0) ? currZipFile.substring(0, currZipFile.lastIndexOf(".")) : currZipFile;
                    partFile = partFile + fileExt + (i + 1);
                    retList.add(partFile);
                }
            }