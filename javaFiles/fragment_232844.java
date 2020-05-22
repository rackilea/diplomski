byte[] encodedBytes = null;
      String contents = "";
      Scanner scanner = null;
      StringBuilder text = new StringBuilder();
      String NL = System.getProperty("line.separator");
        try {
            encodedBytes = new Base64().encode(FileUtils.readFileToByteArray(new File(fFileName)));
            contents = new String(encodedBytes);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
        }
        return "data:image/png;base64,"+contents;