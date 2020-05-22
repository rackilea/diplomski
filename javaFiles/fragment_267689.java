fun awaitShutdown() {
        Spark.stop()

        while (isSparkInitialized()) {
            Thread.sleep(100)
        }
    }

    /**
     * Access the internals of Spark to check if the "initialized" flag is already set to false.
     */
    private fun isSparkInitialized(): Boolean {
        val sparkClass = Spark::class.java
        val getInstanceMethod = sparkClass.getDeclaredMethod("getInstance")
        getInstanceMethod.isAccessible = true
        val service = getInstanceMethod.invoke(null) as Service

        val serviceClass = service::class.java
        val initializedField = serviceClass.getDeclaredField("initialized")
        initializedField.isAccessible = true
        val initialized = initializedField.getBoolean(service)

        return initialized
    }