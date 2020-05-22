PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));
                PdfRenderer.Page page = renderer.openPage(0);
                int pageWidth = page.getWidth();
                int pageHeight = page.getHeight();
                float scale = Math.min((float) REQ_WIDTH / pageWidth, (float) REQ_HEIGHT / pageHeight);
                Bitmap bitmap = Bitmap.createBitmap((int) (pageWidth * scale), (int) (pageHeight * scale), Bitmap.Config.ARGB_8888);
                page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
                imageView.setImageBitmap(bitmap);