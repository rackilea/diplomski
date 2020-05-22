// by using the for-each loop
for (Pattern onePattern : allPatterns) {
   player.play(onePattern);
}

// alternatively, turn the list back into an array and play that
player.play(allPatterns.toArray(new Pattern[0]);