import org.apache.tools.ant.filters.ReplaceTokens 

apply plugin: 'java'

processResources {
   filter(ReplaceTokens, tokens: ['token.to.replace': 'zombo.com'])
}