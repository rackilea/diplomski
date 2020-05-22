String example = ",Group 4: [abc@xyz.com,asd@dsa.com],,Group 4: [abc@xyz.com],,Group 3: [],,Group 2:\n" +
                         "[qwe@rty.com,yui@gui.com,jih@app.com,abc@xyz.com,asd@dsa.com],,Group 1: \n" +
                         "[pick@pick.com,test@pick.com,test1@pick1.com],,Nirmal testGroup: [qwe@rty.com],";
Pattern pattern = Pattern.compile("\\[(.*?)\\]");
Matcher matcher = pattern.matcher(example);
while (matcher.find()) {
    for (String email : matcher.group(1).split(",")) {
        System.out.println(email);
    }
}