import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
public class PassengerArrivals {

    private double T, lambda; // Time interval
    private double waiting;

    public PassengerArrivals(double lambda, double timeInterval) {
        // TODO Auto-generated constructor stub
        this.lambda = lambda;
        this.T = timeInterval;
        this.avg_waiting = 0;


        // Generate the number of events that will occur
        PoissonDistribution pd = new PoissonDistribution(this.lambda);
        int n = pd.sample();

        // Initialize an array to store the arrival times t_i, i = {1,2,..., n}.
        double arrivals[] = new double[n];

        // Generate the arrival times through a U[0,T]
        UniformRealDistribution ud = new UniformRealDistribution(0, this.T);
        for (int i = 0; i < n; ++i) {
            arrivals[i] = ud.sample();
        }

        //The Waiting times between events will be independent and identically distributed exponentialy.
        double sum_waiting_time = 0;
        for (int i = 0; i < n; ++i) {
            // For me, the waiting time is the time the arrival of passenger occurred and he will wait until the time interval will be done.
            sum_waiting_time += timeInterval - arrivals[i];
        }

        // Sometimes I got a NaN, possibly because my lambda was small so no events were generated. So it doesn't hurt to check :P
        if (Double.isNaN(waiting_time)) {
            sum_waiting_time = 0;
        }

        this.avg_waiting = sum_waiting_time / n;
    }

    /**
     * 
     * @return
     */
    public double getAvgWaitingTime() {
        return this.waiting;
    }