rule "Punish"

when
  $seizure: Seizure(markedForPunishment  == true)
then
  $seizure.applyPunishment();