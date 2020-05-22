public class DriveStraight extends Command {

    private double speed;
    private double duration;
    private double heading;
    private Robot.DriveTrain driveTrain;

    public DriveStraight(float driveSpeed, float duration) {
        requires(Robot.DriveTrain);
        driveTrain = new Robot.DriveTrain()            // create new shared instance
        heading = driveTrain.getHeading();             // use instance.
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(duration);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        float currentheading = driveTrain.getHeading();    // use instance created in constructor.
        driveTrain.arcadeDrive(speed, (heading - currentheading) * 0.08);
    }
    ...