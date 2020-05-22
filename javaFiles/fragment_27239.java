Configuration conf = new Configuration();

Job job = Job.getInstance(new Configuration(), "word_count");
//set job configs

job.waitForCompletion(true);
long counter = job.getCounters().findCounter(UpdateCounter.UPDATED).getValue();   

if(counter > 0) 
  // some mapper has seen the condition