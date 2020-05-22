String FileName = ...full path of file...

             MimeTypeMap map = MimeTypeMap.getSingleton();
             String extension = map.getFileExtensionFromUrl(FileName.toLowerCase().replace(" ", "")); // does not work with spaces in filename

             String mimetype = map.getMimeTypeFromExtension(extension);

            Toast.makeText(context, FileName + "\nMimeType: " + mimetype + "\nExtension: " + extension , Toast.LENGTH_SHORT).show();

            if ( mimetype == null )
                {
                mimetype = "text/plain";
                Toast.makeText(context, "MimeType: " + mimetype, Toast.LENGTH_SHORT).show();
                }



            String Url = "file://" + FileName;

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(Url), mimetype);    
            context.startActivity(intent);