boolean personalPronounSeen = false;
for (int i = 0; i < 12; i++) {
    if (thesis.contains(personalPronouns[i])){
        personalPronounSeen = true;
    }
}
if(personalPronounSeen) {
    // print your message...
}