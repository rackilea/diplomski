String str = "the_B-NP camera_I-NP is_B-VP very_B-ADJP easy_I-ADJP to_B-VP use_I-VP ,_O in_B-PP fact_B-NP on_B-PP a_B-NP recent_I-NP trip_I-NP this_B-NP past_I-NP week_I-NP i_I-NP was_B-VP asked_I-VP to_B-VP take_I-VP a_B-NP picture_I-NP of_B-PP a_B-NP vacationing_I-NP elderly_I-NP group_I-NP ._O ";
Pattern ptrn = Pattern.compile("\\S*_I+\\S*");
Matcher matcher = ptrn.matcher(str);
List<String> lst = new ArrayList<>();
while (matcher.find()) {
    lst.add(matcher.group());
}
System.out.println(lst);
// => [camera_I-NP, easy_I-ADJP, use_I-VP, recent_I-NP, trip_I-NP, past_I-NP, week_I-NP, i_I-NP, asked_I-VP, take_I-VP, picture_I-NP, vacationing_I-NP, elderly_I-NP, group_I-NP]