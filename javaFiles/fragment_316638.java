class StatusService : IStatusService {
    private val versionProperties = Properties()

    init {
        versionProperties.load(this.javaClass.getResourceAsStream("/version.properties"))
    }

    override fun getVersion() : String = versionProperties.getProperty("version") ?: "no version"
}