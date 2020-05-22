String path = Environment.getExternalStorageDirectory().toString() + "/DCIM";
                File file = new File(path, "test.txt");

                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }