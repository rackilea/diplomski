public static void main(String[] args) {
    String str = "email1@gmail.com,'email2@gmail.com,email3@gmail.com, email4@gmail.com'" +
            ", 'email5@gmail.com ,email6@gmail.com'";

    Matcher m = Pattern.compile("\\w+@\\w+.com").matcher(str);
    List<String> emailsList = new ArrayList<>();

    while (m.find()){
        emailsList.add(m.group());
    }

    String[]emailsArray = emailsList.toArray(new String[0]);  // if really need an array
    System.out.println(Arrays.toString(emailsArray));
}