switch(input) {
case 1:
    team = orig();
    System.out.println(team);

    mix_word = mix(team);
    System.out.println(mix_word);

    orig_team = team.toCharArray();
    mix_team = mix_word.toCharArray();
    arg_length = mix_team.length;

    // No break; here!
case 2:
    //  do the rest of your thing as if it were case 2
    break;
case 3:
    break;
default:
    System.out.println("input accurate numbers 1 or 2 or 3");
}