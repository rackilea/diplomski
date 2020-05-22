String fileName = f.getName();
            try {
                fileName = URLEncoder.encode(fileName,"UTF-8");
            } catch (UnsupportedEncodingException e1) {             
                e1.printStackTrace();
            }
            String serverUrl = http://mob.krill.order-line.co.uk/MobileService.svc/UploadFile/721/+fileName;