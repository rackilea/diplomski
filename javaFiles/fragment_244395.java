//build.gradle

plugins {
  ...
  id 'idea' //add idea plugin
}

...
//put compiled classes and resources in the same directory (change the path if needed)
idea.module.outputDir file("out/production/classes")