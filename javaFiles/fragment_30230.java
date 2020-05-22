public void split() {
            dirt = sheet.getSubimage(0,0,width,height);
            grass = sheet.getSubimage(width,0,width,height);
            rock = sheet.getSubimage(width*2,0,width,height);
            tree = sheet.getSubimage(0,height,width,height);
            water = sheet.getSubimage(width,height,width,height);
        }