helper.addInline("cImage", new ByteArrayResource(imageByteArr){
            @Override
            public String getFilename() {
                return fileName;
            }
        });