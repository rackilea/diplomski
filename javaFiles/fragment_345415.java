public class SubJob extends Job {

    private Ga ga;

    public SubJob(Ga ga) {
        this.ga = ga;
    }

    @Override
    public doJob() throws Exception {
        ga = ga.merge();
        ga.lastUID = msgnums[i-1];
        ga.count = count[i-1];
        ga.save();
    }
}