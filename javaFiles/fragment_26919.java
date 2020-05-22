apply from: 'my.gradle'

task someOtherTask << {
   println 'doLast'
}

project.tasks.myTask.dependsOn(someOtherTask)