File file = new File(path);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                try {
                    BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

                    int read;
                    byte[] buff = new byte[1024];
                    while ((read = in.read(buff)) > 0) {
                        out.write(buff, 0, read);
                    }
                    out.flush();
                    byte[] bytes = out.toByteArray();

                    image = new ParseFile(name, bytes);
                } catch (FileNotFoundException ex) {
                } catch (IOException ex) {
                }


 if (imageAttached) {
            String name = path.substring(path.lastIndexOf("/"));


            image = new ParseFile(name, Util.convertBitmapToBytes(bitmap));
            image.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        post.put(DuzooConstants.PARSE_POST_IMAGE, image);
                        post.pinInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (dialog.isShowing())
                                    dialog.dismiss();
                            }
                        });
                        post.saveInBackground();
                    }
                }
            });
        } else {
            post.pinInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (dialog.isShowing())
                        dialog.dismiss();
                    returnToHomeActivity();
                }
            });
            post.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                }
            });
        }
    }