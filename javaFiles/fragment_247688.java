@KotlinScript(fileExtension = "custom.ext", compilationConfiguration = ScriptConfiguration::class)
abstract class MyScript(val bindings: Map<String, Any?>) {
    val ortResult = bindings["ortResult"] as OrtResult
    val evalErrors = mutableListOf<OrtIssue>()
}

object ScriptConfiguration : ScriptCompilationConfiguration(
    {
        defaultImports("com.here.ort.model.*", "java.util.*")
        ide {
            acceptedLocations(ScriptAcceptedLocation.Everywhere)
        }
    })