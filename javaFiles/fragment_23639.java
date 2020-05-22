List<TopicPartition> list = new LinkedList<>();
list.add(new TopicPartition("part1", 1));
list.add(new TopicPartition("part2", 2));
resume(list);  
// resume has now been called with argument of a list (which is a collection) 
// containing two TopicPartition objects whit part1, part2 and 1,2 as 
// construction arguments