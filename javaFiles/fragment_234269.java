// repeat for each number from 0 to 11
for (int i = 0; i < 12; i++) {
    // if this string contains the string in personalPronouns[i]
    if (thesis.contains(personalPronouns[i])){
        // print this message
        System.out.println("Oops! Looks like your thesis contains personal pronouns. Remember, avoid using I, you, me, we, us, our, etc. in persuasive essays.");
    } else { // otherwise
        // print this message
        System.out.println("Looks good. Now it's time to start writing! Your essay outline is saved to a txt file called EssayTutorOutline.");
    }
}