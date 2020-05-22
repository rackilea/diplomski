@Synchronized fun restartToMode(mode: AppMode) {
    requireNotNull(context)
    requireNotNull(application)

    // internal logic to potentially produce a new arguments array

    // close previous context
    context.close()

    // and build new one using the new mode
    val builder = SpringApplicationBuilder(SpringMain::class.java)
    application = builder.application()
    context = builder.build().run(*argsArray)
}