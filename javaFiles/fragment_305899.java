public static void main(String[] args) {
        String story = "Hello, I am strHost and I will be accompanied today by someguy1 and anotherguy2. As we walk through the mansion today, feel free to ask someguy1 or anotherguy2 any questions you may have.";
        String str = story.replaceAll("someguy1", "someguy1peter");
        str = str.replaceAll("anotherguy2", "anotherguy2john");
        str = str.replaceAll("strHost", "stringhost");
        System.out.println(str);
    }