String candidateString =
        "Microsoft Visual FoxPro 6.0 language reference 13.02.12";
        //"dffsd fs sfd 12.12.12asd saddsa dasd 12.12.12fsadf sdfsdf sdf 10.10.10";

    Pattern p2 =
        Pattern
            .compile("(.*?(?![0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9])) ([0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9])");

    Matcher matcher2 = p2.matcher(candidateString);

    while (matcher2.find()) {
        System.out.println("String: |" + matcher2.group(1) + "| Date: |"
            + matcher2.group(2) + "|");
    }