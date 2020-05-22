case R.id.settings_capture:
                item.setIcon(R.drawable.capture);                   
                //Resize the webview to the height of the webpage
                int pageHeight = web.getContentHeight();
                LayoutParams browserParams = web.getLayoutParams();
                web.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, pageHeight));

                //Capture the webview as a bitmap
                web.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(web.getDrawingCache());
                web.setDrawingCacheEnabled(false);

               // final DateFormat DF = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
                String out = new SimpleDateFormat("EEE_MMM_dd_yyyy hh:mm.s'.jpg'").format(new Date());

                //Create the filename to use
                String target_filename  = "FolderName-" + (out);
                        //+ ".jpg";
                try {
                    File targetDir = new File(Environment.getExternalStorageDirectory(), "/Enlighten");
                if (!targetDir.exists()){   
                    targetDir.mkdirs(); }
                    File file = new File(targetDir, target_filename);
                    FileOutputStream fos = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                    Toast.makeText(WebViewClientDemoActivity.this, "Capture Saved!\n\nImage Stored @ /sdcard/Location", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(WebViewClientDemoActivity.this, "Problem Storing Image To: /sdcard/Location", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    web.setLayoutParams(browserParams);
                }
                return true;