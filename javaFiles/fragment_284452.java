List < Job > sortedJobs = new ArrayList < Job > ();
        int SJsize = sortedJobs.size();
        List<Job> jobsToRemove = new ArrayList<>();
        for (int i = SJsize - 1; i > 0; i--) {
          for (int j = 0; j < SJsize; j++) {
            if ((sortedJobs.get(i).getStartTime() > sortedJobs.get(j).getStartTime() &&
                sortedJobs.get(i).getStartTime() < sortedJobs.get(j).getFinishTime()) ||
              (sortedJobs.get(i).getFinishTime() > sortedJobs.get(j).getStartTime() &&
                sortedJobs.get(i).getFinishTime() < sortedJobs.get(j).getFinishTime())) {

              //save elements to remove
              jobsToRemove.add(sortedJobs.get(i));
            }
          }
        }

        //actually remove elements, when iteration over list is finished.
        sortedJobs.removeAll(jobsToRemove);