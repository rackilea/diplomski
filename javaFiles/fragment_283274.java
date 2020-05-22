plugins {
    id 'com.eriwen.gradle.js' version '2.14.1'
}


import com.eriwen.gradle.js.tasks.MinifyJsTask
task minifyJS << {
    println "lets minify"
  fileTree('WebContent/js').eachWithIndex { file, index ->
    def dynamicTask = "minify$index"
    task "$dynamicTask" (type: MinifyJsTask) {
      source = file
      dest = file
    }
    tasks."$dynamicTask".execute()
  }
}