public class JavacListener implements BuildListener 

     public void taskFinished(BuildEvent be) {

            if ( be.getTask() instanceof UnknownElement ) {
                UnknownElement ue= (UnknownElement) be.getTask();
                ue.maybeConfigure();

                if ( ue.getTask() instanceof Javac ) {
                Javac task = (Javac)ue.getTask();
                    final Path sourcepath = task.getSrcdir();
                    FindBugsTask fbtask = new FindBugsTask();
                    System.out.println ("Trying FindBugs");
                    fbtask.setSourcePath(sourcepath);
                    fbtask.setAuxClasspath(task.getClasspath());
                    Path destPath = new Path( task.getProject() );
                    destPath.setPath(task.getDestdir().getAbsolutePath());
                    fbtask.setAuxAnalyzepath(destPath);
                    fbtask.setOutputFile(getFileName(task.getProject()));
                    fbtask.setProject(task.getProject());

                    fbtask.setHome(new File("C:\\apps\\findbugs-1.3.0"));
                    fbtask.execute();
                }

            } else {
                System.out.println(be.getTask().getClass().getName());
                System.out.println(be.getTask().getTaskName());
            }
        }
..