//Replace ant-style tokens with properties.
processResources {
    filesMatching('**/*.properties') {
        filter( ReplaceTokens, tokens:  properties )
    }
}