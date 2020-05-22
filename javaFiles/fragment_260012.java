class AliasFreqDictController {

    AliasFreqService aliasFreqService

    def show(String freq, String unit, String language) {
        // have a service method that looks up the instance by these properties...
        respond aliasFreqService.find(freq, unit, language)
    }
}