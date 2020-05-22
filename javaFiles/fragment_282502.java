int width = imageDetail.getWidth();
            int height = imageDetail.getHeight();
            byte[] data = imageDetail.getByteData();
            String name = imageDetail.getName();
            BufferedImage bufferedImage =new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int o = (x * 4) + (y * width * 4);
                    bufferedImage.setRGB(x, y, new Color(data[o] & 0xFF, data[o + 1] & 0xFF, data[o + 2] & 0xFF).getRGB());
                }
            }   
            try {
                ImageIO.write(bufferedImage, "jpg", new File(PDFReportingUtil.baseReportFolderLocation+name+".jpg"));
            } catch (IOException e) {
                PDFReportingUtil.logger.error("Error while executing the thread "+Thread.currentThread().getName()+" ",e);
            }