filesNotMatching("**/*.ttf") {
    it.filter(ReplaceTokens, tokens: [
            releaseVersion: project.version,
            releaseDate: buildDate
    ])

    it.filter(ReplaceTokens, tokens: [
            LOG_LEVEL_ROOT: buildEnvironment=='release' ? 'WARN' : 'INFO',
            LOG_LEVEL_WIRE: buildEnvironment=='mydev' ? 'DEBUG' : 'INFO',
            LOG_LEVEL_CR: buildEnvironment=='release' ? 'INFO' : 'DEBUG',
            LOG_LEVEL_DB_PARAMS: buildEnvironment=='release' ? 'INFO' : 'TRACE',
            LOG_LEVEL_DB_QUERY: buildEnvironment=='release' ? 'DEBUG' : 'DEBUG',
            LOG_LEVEL_SPRING: buildEnvironment=='release' ? 'INFO' : 'INFO'
    ])
}