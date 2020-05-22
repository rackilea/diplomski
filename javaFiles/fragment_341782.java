class MotorDriverService : Service() { 

    override fun onCreate() {
        super.onCreate()
        startMotor()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMotor()
    }
}