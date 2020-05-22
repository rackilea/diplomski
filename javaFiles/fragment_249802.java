Process spark = new SparkLauncher(getEnvironmentVar(ps.getRunAs()))
                        .setSparkHome(cp.fetchProperty(GlobalConstant.spark_submit_work_dir).toString())
                        .setAppResource(cp.fetchProperty(GlobalConstant.spark_app_resource))
                        .setMainClass(cp.fetchProperty(GlobalConstant.spark_main_class))
                        .addAppArgs(ps.getName())
                        //   .setConf(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS,"-Duser.name=hive")
                        .setConf(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, "-Dlog4j.configuration=file:///opt/eim/log4j_submitgnrfromhdfs.properties")
                        .setVerbose(true)
                        .launch();