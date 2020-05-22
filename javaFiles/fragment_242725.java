while ((line = br.readLine()) != null)
{
    Scanner sc = new Scanner(line);
    int lineNumber = sc.nextInt();
    String boyName = sc.next();
    int boyNameFreq = sc.nextInt();
    String girlName = sc.next();
    int girlNameFreq = sc.nextInt();

    if(genderSelected.equals("male") && name.equals(boyName)){
        // .. a boy's name is found
    }
    else if(genderSelected.equals("female") && name.equals(girlName)){
        // .. a girl's name is found
    }

}