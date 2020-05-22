public void ReadFromFile(File file) {

    System.out.print("\n Datei= " + file);

    if(file.exists()){
        try {
        final Scanner scn = new Scanner(file);
            while(scn.hasNextLine()){
                String x = scn.next();
                String y = scn.next();
                String z = scn.next();
                 xs.add(x);
                 ys.add(y);
                 zs.add(z);

            }
            scn.close();
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
    }
    timer = new Timer(500, new ActionListener(){
        int c = 0;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            //System.out.print("\n x= " + Integer.parseInt(x));
           // System.out.print("\t y= " + Integer.parseInt(y));
           // System.out.print("\t z= " + Integer.parseInt(z));


            x_slider.setValue(Integer.parseInt(xs.get(c)));
            y_slider.setValue(Integer.parseInt(ys.get(c)));
            z_slider.setValue(Integer.parseInt(zs.get(c)));
            c++;
            if(c == xs.size()){
                timer.stop();
            }
        }

    });
    timer.start();
}