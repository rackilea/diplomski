String slavePath = 'C:\\Something\\only\\on\\slave\\node'
String masterPath = 'D:\\Something\\only\\on\\master\\node'

stage('One') 
{
    node ('slave')
    {
        bat returnStatus: true, script: 'set'
        println fileExists(slavePath)     // Should be true
        println fileExists(masterPath)    // Should be false
    }
    node ('master')
    {
        bat returnStatus: true, script: 'set'
        println fileExists(slavePath)     // false
        println fileExists(masterPath)    // true
    }
}