FileOutputStream fos = null;
        try {

            String str_path = Environment.getExternalStorageDirectory().toString();
            File file ;
            file = new File(str_path, "Test.xls");
            fos = new FileOutputStream(file);


            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Toast.makeText(MainActivity.this, "Excel Sheet Generated", Toast.LENGTH_SHORT).show();

        }