public class Mutex implements ISchedulingRule {

        public boolean contains(ISchedulingRule rule) {
            return (rule == this);
        }

        public boolean isConflicting(ISchedulingRule rule) {
            return (rule == this);
        }

}// Mutex

public static final ISchedulingRule mutex = new Mutex();