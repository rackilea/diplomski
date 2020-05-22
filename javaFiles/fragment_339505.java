rule "WNPRules_10"
  when
    $reminder:Reminder(source == "HMI")
    $user:User()
    eval($user.isInAgeRange("30-100") && $user.haveAtLeastOptIns("1,2,3,4"))
    Reminder(clickPercentual >= 10)
  then
    $reminder.setPriority(1);update($reminder);
  end