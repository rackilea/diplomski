Pattern pattern = Pattern.compile(""
                + "(?:\\s+|chiffre|job-id|job-nr[.]|job-nr|\\bjob id\\b|job nr[.]|jobnummer|jobnr[.]|jobid|jobcode|job nr\\.|ziffer|kennziffer|kennz\\.|referenz code|referenz-code|"
                + "referenzcode|ref[.] nr[.]|ref[.] id|ref id|ref[.]id|ref[.]-nr[.]|ref[.]- nr[.]|"
                + "referenz nummer|referenznummer|referenz nr[.]|stellenreferenz| referenz-nr[.]|referenznr[.]|referenz|referenznummer der stelle|id#|id #|stellenausschreibungen|" 
                + "stellenausschreibungs\\s?nr[.]|stellenausschreibungs-nr[.]|stellenausschreibungsnr[.]|stellenangebots id|stellenangebots-id|stellenangebotsid|stellen id|stellen-id|stellenid|stellenreferenz|"
                + "stellen-referenz|ref[.]st[.]nr[.]|stellennumer|\\bst[.]-nr[.]\\B|\\bst[.] nr[.]\\B|kenn-nr[.]|positionsnummer|kennwort|stellenkey|stellencode|job-referenzcode|stellenausschreibung|"
                + "bewerbungskennziffer|projekt id|projekt-id|reference number|reference no[.]|reference code|job code|job id|job vacancy no[.]|job-ad-number|auto req id|job ref|\\bstellenausschreibung nr[.]\\B)"
                + ":?\\w*\\s*([A-Z]*\\s*)([!\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}~]*(?:\\w*[!\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}~]*){0,3})?");

String line = "Referenznummer: INDUSTRY Kontakt: ZAsdfsdfS Herr Andrafgdh Neue Str. 7 21244 Buchholz +42341 22322 mdjob.bu44lz@zaqusssis.de Stellenanzeige teilen: Jetzt online bewerben! oder bewerben Sie sich mit\n" +
            "Geben Sie bei Ihrer Bewerbung die Stellenreferenz und die Stellenbezeichnung an! \n" +
            "Stellenreferenz:   21533448-JOtest\n\n" +
            "Stellenausschreibung Nr. PD-666/19";


Matcher m = pattern.matcher(line);
boolean found = false;
while (m.find()) {
     found = true;
     System.out.println("Found value: " + m.group(0) );
     System.out.println("Found value: " + m.group(1) );
     System.out.println("Found value: " + m.group(2) );
     System.out.println(" ----------------------- " );
}
if (!found) {
     System.out.println("NO MATCH");
}