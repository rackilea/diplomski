BuildinEx840 lpd=new BuildinEx840();
            lpd.setMulticharMode(LinePrinterDeviceBase.CHARACTERSET_USA);
//initialise Cutter
            lpd.initCutter();
            LinePrinter lp=new LinePrinter();
            lp.open(lpd);
            lpd.open();
            try{
                lpd.init();
            }catch(IOException e){
                e.printStackTrace();
            }
            for(int i=0; i<5;i++){
                lp.printNormal("Testing the Line Printer");
            }
            int totalLinefeed=listofItemList.size();
//ESC CMD for line feeds
            byte[] lfs=new byte[]{0x1B,'d', 5};
            sendtoExprinter(lpd,lfs);
//ESC CMD for paper cut
            lfs=new byte[]{0x1B,'i'};
            sendtoExprinter(lpd, lfs);

private void sendtoExprinter(BuildinEx840 dev, byte[] instr) {
        try{
            dev.write(instr);
        }catch(IOException e){
            e.printStackTrace();
        }

    }