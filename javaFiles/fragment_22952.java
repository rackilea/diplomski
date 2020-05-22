ByteArrayOutputStream baos = new ByteArrayOutputStream();
response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=sample.pdf");
                OutputStream os = response.getOutputStream();
                baos.writeTo(os);
                os.flush();
                os.close();