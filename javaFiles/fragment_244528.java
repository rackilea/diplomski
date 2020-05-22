public String decode_FileName(String fileName) {
        System.out.println("fileName : " + fileName);
        String decodedfileName = fileName;
        String temp = "";
        Matcher m = Pattern.compile("\\_x(.*?)\\_").matcher(decodedfileName); //rejex which matches _x0020_ kind of charectors
        List<String> unicodeChars = new ArrayList<String>();
        while (m.find()) {
            unicodeChars.add(m.group(1));
        }
        for (int i = 0; i < unicodeChars.size(); i++) {
            temp = unicodeChars.get(i);
            if (isInteger(temp)) {
                String replace_char = String.valueOf(((char) Integer.parseInt(String.valueOf(temp), 16)));//converting  
                decodedfileName = decodedfileName.replace("_x" + temp + "_", replace_char);
            }
        }
        System.out.println("Decoded FileName :" + decodedfileName);
        return decodedfileName;
    }