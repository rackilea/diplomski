public static void main(String[] args) throws Exception {
        String web;
        String result = "";
        for (int i = 0; i < 10; i++) {
            web = "<img src=\"http://image" + i +".jpg\" alt=\"Title of Image " + i + "\" style=\"max-width:460px;\">";
            result += web + "\n";
        }
        System.out.println(result);
        Pattern pattern = Pattern.compile(".*<img src=\"http://(.*)\" alt=\"(.*)\"\\s+sty.*>", Pattern.MULTILINE);

        List<String> imageSources = new ArrayList<String>();
        List<String> imageTitles = new ArrayList<String>();

        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            String imageSource = matcher.group(1);
            String imageTitle = matcher.group(2);
            imageSources.add(imageSource);
            imageTitles.add(imageTitle);

        }

        for(int i = 0; i < imageSources.size(); i++) {
            System.out.println("url: " + imageSources.get(i));
            System.out.println("title: " + imageTitles.get(i));

        }
    }
}