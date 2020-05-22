Thread []tArray=new Thread[idW.length];

        for(int j=0;j<idW.length;j++)
        {
            webtext = d.getWebText(idW[j]); 
            ThreadPrepo tpo =new ThreadPrepo(webtext, host[j%jumhost], "server",     1099,idW[j]);  
            tArray[j]=new Thread(tpo);
            tArray[j].start();
            tArray[j].join();
        }

        //thread untuk setfitur tanpa rmi
        int ukuran=idW.length;
        ProsesSetfitur pro=new ProsesSetfitur(idW);
        Thread t2=new Thread(pro);
        t2.start();