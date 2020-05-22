properties {
    maxActive = 50
    maxIdle = 25
    minIdle = 5
    initialSize = 5
    minEvictableIdleTimeMillis = 60000
    timeBetweenEvictionRunsMillis = 60000
    maxWait = 10000

    // Connection Validation Settings
    testOnBorrow=true
    testWhileIdle=true
    testOnReturn=true
    validationQuery="SELECT 1"
}