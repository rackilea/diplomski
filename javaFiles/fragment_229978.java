while((i=ap.evalXPath())!=-1){
            // if filesize is at max create a new File
            if(fos.getChannel().size() > maxFileSize){
                finishXml(fos,contentNode);
                LOG.info("Finished file with " + k + "nodes");
                fos = getNewXml(contentNode);
                k=0;

            }
            k++;
            long l = vn.getElementFragment();
            fos.write(ba, (int)l, (int)(l>>32));
            fos.write("\n".getBytes());
        }