try {
           m.addAttachment(zipName);
           // m.addAttachment(filename);
            if (m.send()) {
               Toast.makeText(MainActivity.this,"Message sent",Toast.LENGTH_LONG);
                System.out.println("Message sent");
                return 1;
            } else {
                Toast.makeText(MainActivity.this,"Mail Yollandı",Toast.LENGTH_LONG);
                return 2;
            }

        } catch (Exception e) {
            Log.e("MailApp", "Mail Yollandı", e);
            return 3;
        }