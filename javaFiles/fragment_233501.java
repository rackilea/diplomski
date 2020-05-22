public class DriveStraight extends Command {
    private Robot.DriveTrain driveTrain;

    public DriveStraight(float driveSpeed, float duration, DriveTrain driveTrain) {
        this.driveTrain = driveTrain; // use instance created elsewhere
    ...